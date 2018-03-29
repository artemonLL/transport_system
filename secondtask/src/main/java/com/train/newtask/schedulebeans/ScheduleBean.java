package com.train.newtask.schedulebeans;



import com.train.newtask.entity.Schedule;
import com.train.newtask.EJB.ScheduleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Dependent
@Named(value = "scheduleBean")
@SessionScoped
public class ScheduleBean implements Serializable
{

    @Inject
    private Logger logger;

    @EJB
    private ScheduleRepository scheduleRepository;


    private List<Schedule> scheduleList;


    @PostConstruct
    private void init()
    {
        scheduleList=scheduleRepository.getAll();
    }

    public List<Schedule> getScheduleList()
    {
        return scheduleList;
    }

    public int getScheduleCount()
    {
        return scheduleList.size();
    }



}
