package com.transport.system.service;

import com.transport.system.dao.ScheduleDao;
import com.transport.system.dao.ScheduleDaoIml;
import com.transport.system.messaging.MessageSender;
import com.transport.system.model.Schedule;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    MessageSender messageSender;

    private static final Logger logr = Logger.getLogger(ScheduleDaoIml.class);

    /**
     * Returns Schedule from database by Schedule's id.
     *
     * @param schedule_id Schedule's id in the database.
     * @return Schedule obj.
     **/
    @Override
    public Schedule getScheduleById(int schedule_id) {
        return this.scheduleDao.getScheduleById(schedule_id);
    }

    /**
     * Add Schedule to database.
     *
     * @param schedule Schedule entity.
     * @return void.
     **/
    @Override
    public void addSchedule(Schedule schedule) {
        schedule.setWay_position(1 + (int) (Math.random() * 15));

        this.scheduleDao.addSchedule(schedule);

        messageSender.sendMessage(schedule.getStation().getStation_name());
        logr.info("Schedule was add" + schedule);
    }

    /**
     * Update Schedule in database by schedule.
     *
     * @param schedule schedule.
     * @return boolean.
     **/
    @Override
    public boolean updateSchedule(Schedule schedule) {
        Schedule newSchedule = scheduleDao.getScheduleById(schedule.getSchedule_id());

        if (newSchedule.getStation().getStation_name() != null) {
            scheduleDao.updateSchedule(schedule);
            messageSender.sendMessage(schedule.getStation().getStation_name());
            logr.info("Schedule was  updated " + schedule);
            return true;
        }
        return false;
    }

    /**
     * Remove Schedule from database by Schedule's id.
     *
     * @param schedule_id Schedule's id in the database.
     * @return boolean.
     **/
    @Override
    public boolean removeSchedule(int schedule_id) {

        Schedule schedule = scheduleDao.getScheduleById(schedule_id);
        if (schedule != null) {
            logr.info("Schedule was  removed " + schedule);
            scheduleDao.removeSchedule(schedule_id);
            messageSender.sendMessage(schedule.getStation().getStation_name());
            return true;
        }
        return false;
    }

    /**
     * Returns all schedules from database .
     *
     * @return List<Schedule>.
     **/
    @Override
    public List<Schedule> getScheduleList() {

        List<Schedule> scheduleList = this.scheduleDao.getScheduleList();
        Collections.reverse(scheduleList);

        return scheduleList;
    }

    /**
     * Returns schedule list from database by station's id.
     *
     * @param station_id station's id in the database.
     * @return List<Schedule>.
     **/
    @Override
    public List<Schedule> getScheduleListByStation(int station_id) {
        return this.scheduleDao.getScheduleListByStation(station_id);
    }

    /**
     * Returns schedule list from database by between dates and two stations .
     *
     * @param dateOne    schedule's time_msk in the database.
     * @param dateTwo    schedule's time_msk in the database.
     * @param stationOne station's id in the database.
     * @param stationTwo station's id in the database.
     * @return List<Schedule>.
     **/
    @Override
    public List<Schedule> selectByDatesAndStations(Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo) {
        List<Schedule> list = this.scheduleDao.selectByDatesAndStations(dateOne, dateTwo, stationOne, stationTwo);
        Schedule schedule;
        return this.scheduleDao.selectByDatesAndStations(dateOne, dateTwo, stationOne, stationTwo);
    }
}
