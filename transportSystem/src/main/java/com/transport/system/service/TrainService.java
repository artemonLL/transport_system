package com.transport.system.service;

import com.transport.system.model.Train;

import java.util.List;

public interface TrainService
{

    /**
     * Returns Train from database by Train's id.
     * @param train_id Train's id in the database.
     *                 @return Train obj.
     **/
    public Train getTrainById(int train_id) ;
    /**
     * Returns Train from database by Train's number.
     * @param train_number Train's number in the database.
     *                 @return Train obj.
     **/
    public Train getTrainByName(String train_number);

    /**
     * Add Train to database.
     * @param train Train entity .
     *                 @return void.
     **/
    public boolean addTrain(Train train);

    /**
     * Update Train in database .
     * @param train Train entity .
     *                 @return void.
     **/
    public void updateTrain(Train train);

    /**
     * Returns all Trains from database.
     *                 @return List<Train>.
     **/
    public List<Train> getTrainList();

    public int getFreePlaces(int train_id);


}


