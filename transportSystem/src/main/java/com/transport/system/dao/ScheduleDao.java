package com.transport.system.dao;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface ScheduleDao {

    public Schedule getScheduleById(int schedule_id) ;

    public boolean removeSchedule(int schedule_id);

    public boolean addSchedule(Schedule schedule);

    public boolean updateSchedule(Schedule schedule);

    public List<Schedule> getScheduleList();

    public List<Schedule> getScheduleByTrainId(int train_id);


    public List<Schedule> getScheduleListByStation(int station_id);



    public List<Schedule> selectByDatesAndStations(Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo);





}
