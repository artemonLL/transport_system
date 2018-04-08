package com.transport.system;

import com.transport.system.dao.StationDaoImpl;
import com.transport.system.dao.TrainDao;
import com.transport.system.dao.TrainDaoImpl;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.StationServiceImpl;
import com.transport.system.service.TrainService;
import com.transport.system.service.TrainServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;



/**
 * Testing the main methods of TrainsService.
 * */
@RunWith(MockitoJUnitRunner.class)
public class TrainsServiceTests {
    @Mock
    private TrainDaoImpl trainDao;
    @InjectMocks
    private TrainServiceImpl trainService;
    private  Train train1=new Train();
    private  Train train2=new Train();
    @Before
    public void init() {
        train1.setTrain_id(999);
        train1.setTrain_number("TestTrain");
        train1.setPlaces(111);
    }
    /**
     * Testing addTrain method from StationService
     * first time
     * use mock "trainDao".
     * */
    @Test
    public void test1TrainAdd()
    {
        Mockito.when(trainDao.addTrain(train1)).thenReturn(true);
        Mockito.when(trainService.getTrainByName(train1.getTrain_number())).thenReturn(null);
        Train train=new Train();
        train.setPlaces(222);
        train.setTrain_number("TestTrain");
        boolean isAdd=trainService.addTrain(train);

        Assert.assertTrue("Train is  Double Add-"+isAdd,isAdd);
    }
    /**
     * Testing addTrain method from StationService
     * second time
     * use mock "trainDao".
     * */
    @Test
    public void test2TrainAddNext()
    {
        Mockito.when(trainDao.addTrain(train1)).thenReturn(true);
        Mockito.when(trainService.getTrainByName(train1.getTrain_number())).thenReturn(train1);
        Train train=new Train();
        train.setPlaces(222);
        train.setTrain_number("TestTrain");

        boolean isAdd=trainService.addTrain(train);

        Assert.assertFalse("Train is  Double Add-"+isAdd,isAdd);
    }


    @Test
    public void test3TrainGetById()
    {
        Mockito.when(trainService.getTrainById(train1.getTrain_id())).thenReturn(train1);
        Train train=new Train();

        train=trainService.getTrainById(999);
        Assert.assertEquals("TestTrain",train.getTrain_number());

    }
}


