package com.transport.system.dao;

import com.transport.system.model.Train;

import java.util.List;

public interface TrainDao
{

    public Train getTrainById(int train_id) ;

    public Train getTrainByName(String train_number);

    public void addTrain(Train train);

    public void updateTrain(Train train);

    public List<Train> getTrainList();

    public int getTrainIdByName(String train_number);




}
