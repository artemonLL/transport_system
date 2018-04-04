package com.transport.system.service;

import com.transport.system.dao.ScheduleDao;
import com.transport.system.dao.ScheduleDaoIml;
import com.transport.system.messaging.MessageSender;
import com.transport.system.model.Schedule;
import com.transport.system.model.Train;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;


    @Autowired
    MessageSender messageSender;

    private static final Logger logr = Logger.getLogger(ScheduleDaoIml.class);

    @Override
    public Schedule getScheduleById(int schedule_id) {
        return this.scheduleDao.getScheduleById(schedule_id);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        schedule.setWay_position(1 + (int)(Math.random() * 15));

        this.scheduleDao.addSchedule(schedule);

      messageSender.sendMessage(schedule.getStation().getStation_name());
       // logr.warn("**********************************GET LIST  "+scheduleList.toString());
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        Schedule newSchedule=scheduleDao.getScheduleById(schedule.getSchedule_id());

        if(newSchedule.getStation().getStation_name()!=null) {
            scheduleDao.updateSchedule(schedule);
            messageSender.sendMessage(schedule.getStation().getStation_name());

            return true;
        }
        return false;
    }

    @Override
    public boolean removeSchedule(int schedule_id) {

        Schedule schedule=scheduleDao.getScheduleById(schedule_id);
        if(schedule!=null)
        {
            scheduleDao.removeSchedule(schedule_id);
            messageSender.sendMessage(schedule.getStation().getStation_name());
            return true;
        }
        return false;
    }

    @Override
    public List<Schedule> getScheduleList()
    {

        List<Schedule> scheduleList=this.scheduleDao.getScheduleList();
        Collections.reverse(scheduleList);

        return scheduleList;
    }

    @Override
    public List<Schedule> getScheduleListByStation(int station_id) {
        return this.scheduleDao.getScheduleListByStation(station_id);
    }

    @Override
    public List<Schedule> selectByDatesAndStations (Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo) {

        List<Schedule> list=this.scheduleDao.selectByDatesAndStations(dateOne,dateTwo,stationOne,stationTwo);
        Schedule schedule;


        return this.scheduleDao.selectByDatesAndStations(dateOne,dateTwo,stationOne,stationTwo);
    }
}
