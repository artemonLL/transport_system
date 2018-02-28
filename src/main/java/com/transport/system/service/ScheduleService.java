package com.transport.system.service;

import com.transport.system.model.Schedule;

import java.util.List;

public interface ScheduleService {

    public Schedule getScheduleById(int schedule_id) ;

    //   public Schedule getScheduleByWayPosition(int way_position);

    public void addSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public List<Schedule> getScheduleList();




}
