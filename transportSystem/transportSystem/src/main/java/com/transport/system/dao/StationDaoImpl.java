package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {


    private static final Logger logr = Logger.getLogger(StationDaoImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Station getStationById(int station_id) {
        Station station = new Station();
        try {

            Session session = this.sessionFactory.getCurrentSession();
            station = (Station) session.load(Station.class, new Integer(station_id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return station;

    }

    @Override
    public Station getStationByName(String station_name) {
        Station station = new Station();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(Station.class);
            userCriteria.add(Restrictions.eq("station_name", station_name));
            station = (Station) userCriteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return station;
    }

    @Override
    public void addStation(Station station) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(station);
            logr.warn(("ADD STATION " + station.getStation_name()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStation(Station station) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(station);
    }

    @Override
    public List<Station> getStationList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Station> stationList = session.createQuery("from Station").list();
        return stationList;
    }


    public void removeStation(int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Station station= (Station) session.load(Station.class, new Integer(id));
            if (station != null) {
                session.delete(station);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

