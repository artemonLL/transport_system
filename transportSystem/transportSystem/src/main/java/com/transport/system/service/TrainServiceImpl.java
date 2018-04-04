package com.transport.system.service;

import com.transport.system.dao.TrainDao;
import com.transport.system.model.Train;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



@Service
@Transactional
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;



    private static final Logger logr = Logger.getLogger(TrainServiceImpl.class);

    @Override
    public Train getTrainById(int train_id) {
        return this.trainDao.getTrainById(train_id);
    }

    @Override
    public Train getTrainByName(String train_number)
    {
        return this.trainDao.getTrainByName(train_number);
    }

    @Override
    public boolean addTrain(Train train) {

        boolean flag;
        if (trainDao.getTrainByName(train.getTrain_number())!= null) {
            flag= false;
        }
        else {
            this.trainDao.addTrain(train);
            flag=true;
        }

        return flag;
    }

    @Override
    public void updateTrain(Train train) {
        this.trainDao.updateTrain(train);
    }

    @Override
    public List<Train> getTrainList() {
        List<Train> trainList = this.trainDao.getTrainList();

        Collections.sort(trainList, Train.COMPARE_BY_ID);
        return trainList;
    }

    @Override
    public int getFreePlaces(int train_id) {
        return this.getFreePlaces(train_id);
    }


}
