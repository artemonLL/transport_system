package com.transport.system.service;

import com.transport.system.model.Train;

import java.util.List;

public interface TrainService
{

    public Train getTrainById(int train_id) ;

    public Train getTrainByName(String train_number);


    public void addTrain(Train train);


    public void updateTrain(Train train);


    public List<Train> getTrainList();







}


