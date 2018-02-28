package com.transport.system.service;

import com.transport.system.model.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    public Schedule getScheduleById(int schedule_id) ;

    //   public Schedule getScheduleByWayPosition(int way_position);

    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public List<Schedule> getScheduleList();


    public List<Schedule> selectByDatesAndStations(Date dateOne, Date dateTwo, int stationOne, int stationTwo);





}
