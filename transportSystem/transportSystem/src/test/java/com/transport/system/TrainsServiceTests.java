package com.transport.system;

import com.transport.system.dao.TrainDao;
import com.transport.system.model.Train;
import com.transport.system.service.TrainService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;
import org.junit.runner.RunWith;




@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
public class TrainsServiceTests {

    @Autowired
    private TrainService trainService;


    @Test
    public void testTrainAdd()
    {
        Train train=new Train();
        train.setPlaces(222);
        train.setTrain_number("A122");
        boolean isAdd=trainService.addTrain(train);

        Assert.assertFalse("Train is  Double Add-"+isAdd,isAdd);
    }

    @Test
    public void testTrainGetByID()
    {
        Train train=trainService.getTrainById(37);
        Assert.assertEquals("A122",train.getTrain_number());

    }







}


