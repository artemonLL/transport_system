package com.transport.system;

import com.transport.system.dao.TrainDao;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.TrainService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;




@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
public class TrainsServiceTests {

    @Autowired
    private TrainService trainService;




    @Test
    public void test1TrainAdd()
    {
        Train train=new Train();
        train.setPlaces(222);
        train.setTrain_number("TestTrain");
        boolean isAdd=trainService.addTrain(train);

        Assert.assertTrue("Train is  Double Add-"+isAdd,isAdd);
    }
    @Test
    public void test2TrainAddNext()
    {
        Train train=new Train();
        train.setPlaces(222);
        train.setTrain_number("TestTrain");
        boolean isAdd=trainService.addTrain(train);

        Assert.assertFalse("Train is  Double Add-"+isAdd,isAdd);
    }

    @Test
    public void test3TrainGetById()
    {
        Train train=trainService.getTrainByName("TestTrain");
        Assert.assertEquals("TestTrain",train.getTrain_number());

    }


    @Test
    public void test4RemoveTrain() {

        Train train=new Train();
        train=trainService.getTrainByName("TestTrain");
        boolean isRemove=trainService.removeTrain(train.getTrain_id());
        Assert.assertTrue("TestTrain was remove", isRemove);

    }




}


