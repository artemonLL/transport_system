package com.transport.system;


import com.transport.system.dao.ScheduleDaoIml;
import com.transport.system.dao.StationDaoImpl;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.StationService;
import com.transport.system.service.StationServiceImpl;
import com.transport.system.service.TrainService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.log4j.Logger;

@RunWith(MockitoJUnitRunner.class)
public class StationsServiceTests {

    @Mock
    private StationDaoImpl stationDao;

    @InjectMocks
    private StationServiceImpl stationServiceImpl;

    private Station station1 = new Station();
    private Station station2 = new Station();


    private static final Logger logr = Logger.getLogger(ScheduleDaoIml.class);

    @Before
    public void init() {
        station1.setStation_name("TestStation");
        station1.setStation_id(999);
    }

    @Test
    public void testStationAdd() {
        Station station=new Station();
        station.setStation_name("TestStation");
        Mockito.when(stationDao.addStation(station1)).thenReturn(true);
        Mockito.when(stationDao.getStationByName(station1.getStation_name())).thenReturn(null);


        boolean isAdd = stationServiceImpl.addStation(station1);

        logr.warn("TEST ADD 1 IS end with =" + isAdd);
        Assert.assertTrue(" Add Train  first time-" + isAdd, isAdd);
    }


    @Test
    public void testStationAddNext() {
        Station station=new Station();
        station.setStation_name("TestStation");
        Mockito.when(stationDao.addStation(station1)).thenReturn(true);
        Mockito.when(stationDao.getStationByName(station1.getStation_name())).thenReturn(station1);
        boolean isAdd =  stationServiceImpl.addStation(station1);

        Assert.assertFalse(" re-adding a Train-" + isAdd, isAdd);
    }

    @Test
    public void testGetStationById() {
        Mockito.when(stationDao.getStationByName(station1.getStation_name())).thenReturn(station1);

        Station station = new Station();

        station = stationServiceImpl.getStationByName("TestStation");

        Assert.assertEquals("TestStation", station.getStation_name());
    }  }


