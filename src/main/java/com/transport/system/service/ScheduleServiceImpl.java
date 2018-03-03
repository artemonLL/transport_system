package com.transport.system.service;

import com.transport.system.dao.ScheduleDao;
import com.transport.system.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;



@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public Schedule getScheduleById(int schedule_id) {
        return this.scheduleDao.getScheduleById(schedule_id);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        this.scheduleDao.addSchedule(schedule);

    }

    @Override
    public void updateSchedule(Schedule schedule) {

        this.scheduleDao.updateSchedule(schedule);
    }


    @Override
    public List<Schedule> getScheduleList() {
        return this.scheduleDao.getScheduleList();
    }

    @Override
    public List<Schedule> selectByDatesAndStations (Time dateOne, Time dateTwo, Date date, int stationOne, int stationTwo) {

        return this.scheduleDao.selectByDatesAndStations(dateOne,dateTwo,date,stationOne,stationTwo);
    }
}
