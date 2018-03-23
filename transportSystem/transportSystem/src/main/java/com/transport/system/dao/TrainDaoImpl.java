package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.StationService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TrainDaoImpl implements TrainDao {

    private static final Logger logr = Logger.getLogger(TrainDaoImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private StationService stationService;


    @Override
    public Train getTrainById(int train_id) {

        Train train = new Train();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            train = (Train) session.load(Train.class, new Integer(train_id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return train;
    }

    @Override
    public Train getTrainByName(String train_number) {

        Train train = new Train();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(Train.class);
            userCriteria.add(Restrictions.eq("train_number", train_number));
            train = (Train) userCriteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return train;
    }


    @Override
    public int getTrainIdByName(String train_number) {


        Train train = new Train();
        try {
            logr.warn(String.format("----------trainDAO getTrainIdByName get " + train_number));
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(Train.class);
            userCriteria.add(Restrictions.eq("train_number", train_number));
            train = (Train) userCriteria.uniqueResult();

            logr.warn(String.format("----------trainDAO getfrom database" + train.getTrain_number() + " " + train.getTrain_id()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return train.getTrain_id();
    }

    @Override
    public int getFreePlaces(int train_id) {

        Train train = new Train();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            train = (Train) session.load(Train.class, new Integer(train_id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return train.getPlaces();

    }


    @Override
    public void addTrain(Train train) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(train);
            logr.warn(String.format("ADD TRAIN " + train.getTrain_number() + " with " + train.getPlaces() + " places"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateTrain(Train train) {
        try {
            Session session = this.sessionFactory.getCurrentSession();

            session.update(train);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Train> getTrainList() {
        List<Train> trainList = new ArrayList<>();

        try {
            Session session = this.sessionFactory.getCurrentSession();
            trainList = session.createQuery("from Train").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainList;
    }
}


