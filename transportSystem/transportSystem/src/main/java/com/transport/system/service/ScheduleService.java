package com.transport.system.service;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

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

    public List<Schedule> getScheduleByTrainId(int train_id);


    public List<Schedule> getScheduleListByStation(int station_id);




    public List<Schedule> selectByDatesAndStations(Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo);





}
