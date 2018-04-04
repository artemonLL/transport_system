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

    /**
     * Get Train by ID  method returns Train from database
     * by Train ID. Method get Train from train table.
     *
     * @param train_id train id.
     * @return Train entity.
     */
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

    /**
     * Get Train by Name  method returns Train from database
     * by Train Name. Method get Train from train table.
     *
     * @param train_number train number.
     * @return Train entity.
     */
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

    /**
     * Get Free Places method returns free places in the train from the database.
     * by the train ID. A way to get free seats on the train from the train table.
     *
     * @param train_id train ID.
     * @return int free places.
     */
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

    /**
     * Add Train method add Train to database.
     * Method add Train to train table.
     *
     * @param train train entity.
     * @return void.
     */
    @Override
    public boolean addTrain(Train train) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(train);
            logr.warn(String.format("ADD TRAIN " + train.getTrain_number() + " with " + train.getPlaces() + " places"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Update Train method returns Update Train in database.
     * by the train. Method update Train in train table.
     *
     * @param train Train entity.
     * @return void.
     */
    @Override
    public void updateTrain(Train train) {
        try {
            Session session = this.sessionFactory.getCurrentSession();

            session.update(train);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Get Train List method get List<Train> from database.
     * Method get List<Train> from train table.
     *
     * @return List<Train>.
     */
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


