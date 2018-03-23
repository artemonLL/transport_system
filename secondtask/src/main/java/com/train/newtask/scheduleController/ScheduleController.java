package com.train.newtask.scheduleController;



import com.train.newtask.EJB.UpdateListener;
import com.train.newtask.entity.Schedule;
import com.train.newtask.EJB.ScheduleEJB;
import com.train.newtask.entity.SimpleSchedule;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;


@Named(value = "scheduleBean")
@SessionScoped
public class ScheduleController implements Serializable
{
    @Inject
    private Logger logger;

    @EJB
    private ScheduleEJB scheduleEJB;

    private List<SimpleSchedule> scheduleList;

    @PostConstruct
    private void init()
    {
        scheduleList=scheduleEJB.getAllSchedule();
    }

    public List<SimpleSchedule> getScheduleList()
    {
        return scheduleList;
    }



}
