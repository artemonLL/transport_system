package com.transport.system.dao;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

import java.sql.Date;
import java.util.List;

public interface ScheduleDao {

    public Schedule getScheduleById(int schedule_id) ;


    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public List<Schedule> getScheduleList();


    public List<Schedule> selectByDatesAndStations(Date dateOne,Date dateTwo,int stationOne,int stationTwo);





}
