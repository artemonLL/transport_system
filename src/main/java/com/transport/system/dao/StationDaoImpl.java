package com.transport.system.dao;

import com.transport.system.model.Station;
import com.transport.system.model.Train;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Station getStationById(int station_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Station station=(Station)session.load(Station.class,new Integer(station_id));
        return station;
    }

    @Override
    public Station getStationByName(String station_name) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(Station.class);
        userCriteria.add(Restrictions.eq("station_name",station_name));
        Station station=(Station)userCriteria.uniqueResult();

        return station;
    }

    @Override
    public void addStation(Station station) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(station);
    }

    @Override
    public void updateStation(Station station) {

        Session session=this.sessionFactory.getCurrentSession();
        session.update(station);
    }

    @Override
    public List<Station> getStationList() {
        Session session=this.sessionFactory.getCurrentSession();
        List<Station> stationList= session.createQuery("from Station").list();
        return stationList;
    }




}

