package com.transport.system.service;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface ScheduleService {


/**
 * Returns Schedule from database by Schedule's id.
 * @param schedule_id Schedule's id in the database.
 *                 @return Schedule obj.
 **/
    public Schedule getScheduleById(int schedule_id) ;

    /**
     * Add Schedule to database.
     * @param schedule Schedule entity.
     * @return void.
     **/
    public void addSchedule(Schedule schedule);

    /**
     * Update Schedule in database by schedule.
     * @param schedule schedule.
     *                 @return boolean.
     **/
    public  boolean updateSchedule(Schedule schedule);

    /**
     * Remove Schedule from database by Schedule's id.
     * @param schedule_id Schedule's id in the database.
     *                 @return boolean.
     **/
    public boolean removeSchedule(int schedule_id);

    /**
     * Returns all schedules from database .
     *   @return List<Schedule>.
     **/
    public List<Schedule> getScheduleList();

    /**
     * Returns schedule list from database by station's id.
     * @param station_id station's id in the database.
     *                 @return List<Schedule>.
     **/
    public List<Schedule> getScheduleListByStation(int station_id);

    /**
     * Returns schedule list from database by between dates and two stations .
     * @param dateOne schedule's time_msk in the database.
     * @param dateTwo schedule's time_msk in the database.
     * @param stationOne station's id in the database.
     * @param stationTwo station's id in the database.
     *                 @return List<Schedule>.
     **/
    public List<Schedule> selectByDatesAndStations(Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo);





}
