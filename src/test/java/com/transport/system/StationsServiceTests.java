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

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
public class StationsServiceTests {


    @Autowired
    private StationService stationService;


    @Test
    public void testTrainAdd() {

        Station station=new Station();
        station.setStation_name("TestStation");

        boolean isAdd = stationService.addStation(station);

        Assert.assertFalse("Train is  Double Add-" + isAdd, isAdd);
    }

    @Test
    public void testTrainGetByID() {

        Station station=new Station();
        station=stationService.getStationByName("TestStation");
        Assert.assertEquals("TestStation", station.getStation_name());

    }


}


