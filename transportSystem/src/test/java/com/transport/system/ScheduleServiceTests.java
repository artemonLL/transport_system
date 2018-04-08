package com.transport.system;


import com.transport.system.dao.ScheduleDaoIml;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.ScheduleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Testing the main methods of ScheduleService.
 * */
@RunWith(MockitoJUnitRunner.class)
public class ScheduleServiceTests {

    @Mock
    private ScheduleDaoIml scheduleDaoIml;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;
    private Schedule schedule1 = new Schedule();
    private Schedule schedule2 = new Schedule();
    private Train train = new Train();
    private Station station = new Station();

    @Before
    public void init() {
        train.setPlaces(2);
        train.setTrain_number("A123");
        train.setTrain_id(123);
        station.setStation_id(123);
        station.setStation_name("Paris");
        schedule1.setSchedule_id(1);
        schedule1.setWay_position(1);
        schedule1.setTime_msk(new Timestamp(new Date().getTime()));
        schedule1.setTrain(train);
        schedule1.setStation(station);
        schedule1.setSchedule_id(3);
        schedule1.setWay_position(5);
        schedule1.setTime_msk(new Timestamp(new Date().getTime()));
        schedule1.setTrain(train);
        schedule1.setStation(station);
    }

    /**
     * Testing the removeSchedule method from ScheduleService
     * with not null param.
     * use mock "scheduleDaoIml".
     * */
    @Test
    public void test1RemoveSchedule() {
        Mockito.when(scheduleDaoIml.getScheduleById(schedule1.getSchedule_id())).thenReturn(schedule1);
        Mockito.when(scheduleDaoIml.removeSchedule(schedule1.getSchedule_id())).thenReturn(true);

        boolean deleted = scheduleService.removeSchedule(schedule1.getSchedule_id());
        Assert.assertTrue(" schedule deleted -" + deleted, deleted);
   }
    /**
     * Testing the removeSchedule method from ScheduleService
     * with null param.
     * use mock "scheduleDaoIml".
     * */
    @Test
    public void test2RemoveNULLSchedule() {
        Mockito.when(scheduleDaoIml.getScheduleById(schedule1.getSchedule_id())).thenReturn(null);
        Mockito.when(scheduleDaoIml.removeSchedule(schedule1.getSchedule_id())).thenReturn(true);
        boolean deleted = scheduleService.removeSchedule(schedule1.getSchedule_id());
        Assert.assertFalse(" schedule deleted -" + deleted, deleted);
    }
    /**
     * Testing the updateSchedule method from ScheduleService
     * with not null param.
     * use mock "scheduleDaoIml".
     * */
    @Test
    public void test3UpdateSchedule() {
        Mockito.when(scheduleDaoIml.getScheduleById(schedule1.getSchedule_id())).thenReturn(schedule1);
        Mockito.when(scheduleDaoIml.updateSchedule(schedule1)).thenReturn(true);

        boolean isUpdate = scheduleService.removeSchedule(schedule1.getSchedule_id());
        Assert.assertTrue(" schedule deleted -" + isUpdate, isUpdate);
    }
    /**
     * Testing the updateSchedule method from ScheduleService
     * with null param.
     * use mock "scheduleDaoIml".
     * */
    @Test
    public void test4UpdateNULLSchedule() {
        Mockito.when(scheduleDaoIml.getScheduleById(schedule1.getSchedule_id())).thenReturn(null);
        Mockito.when(scheduleDaoIml.updateSchedule(schedule1)).thenReturn(true);
        boolean isUpdate = scheduleService.removeSchedule(schedule1.getSchedule_id());
        Assert.assertFalse(" schedule deleted -" + isUpdate, isUpdate);
    }

    /**
     * Testing the getSchedule method from ScheduleService
     * use mock "scheduleDaoIml".
     * */
    @Test
    public void test5GetSchedule() {
        Mockito.when(scheduleDaoIml.getScheduleById(schedule1.getSchedule_id())).thenReturn(schedule1);
        Schedule schedule = scheduleService.getScheduleById(1);
        Assert.assertEquals("A123", schedule.getTrain().getTrain_number());
    }
}
