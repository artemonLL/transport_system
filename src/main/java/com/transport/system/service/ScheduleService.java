package com.transport.system.service;

import com.transport.system.model.Schedule;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface ScheduleService {

    public Schedule getScheduleById(int schedule_id) ;

    //   public Schedule getScheduleByWayPosition(int way_position);

    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public List<Schedule> getScheduleList();


    public List<Schedule> selectByDatesAndStations(Time dateOne, Time dateTwo, Date date, int stationOne, int stationTwo);





}
