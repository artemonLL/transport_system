package com.transport.system.service;

import com.transport.system.dao.TrainDao;
import com.transport.system.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;

    @Override
    public Train getTrainById(int train_id) {
        return this.trainDao.getTrainById(train_id);
    }

    @Override
    public Train getTrainByName(String train_number) {
        return this.trainDao.getTrainByName(train_number);
    }

    @Override
    public void addTrain(Train train) {
        this.trainDao.addTrain(train);
    }

    @Override
    public void updateTrain(Train train) {
        this.trainDao.updateTrain(train);
    }

    @Override
    public List<Train> getTrainList() {
        return this.trainDao.getTrainList();
    }

    @Override
    public int getTrainIdByName(String train_number) {
        return this.trainDao.getTrainIdByName(train_number);
    }


}
