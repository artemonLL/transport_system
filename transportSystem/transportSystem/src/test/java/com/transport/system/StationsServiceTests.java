package com.transport.system;


import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.StationService;
import com.transport.system.service.TrainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
public class StationsServiceTests {

    private static final Logger logr = Logger.getLogger(StationsServiceTests.class);

    @Autowired
    private StationService stationService;


    @Test
    public void testStationAdd() {

        Station station=new Station();
        station.setStation_name("TestStation");

        boolean isAdd = stationService.addStation(station);
        logr.warn("TEST ADD 1 IS end with ="+isAdd);
        Assert.assertTrue(" Add Train  first time-" + isAdd, isAdd);
    }



    @Test
    public void testStationAddNext() {

        Station station=new Station();
        station.setStation_name("TestStation");

        boolean isAdd = stationService.addStation(station);

        Assert.assertFalse("Train is  Double Add-" + isAdd, isAdd);
    }

    @Test
    public void testStationGetByID() {

        Station station=new Station();
        station=stationService.getStationByName("TestStation");
        Assert.assertEquals("TestStation", station.getStation_name());

    }

    @Test
    public void testRemoveStation() {

        Station station=new Station();
        station=stationService.getStationByName("TestStation");
        boolean isRemove=stationService.removeStation(station.getStation_id());
        Assert.assertTrue("Station was remove", isRemove);

    }
}
