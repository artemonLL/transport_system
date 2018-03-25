package com.train.newtask.scheduleController;



import com.train.newtask.EJB.UpdateListener;
import com.train.newtask.EJB.ScheduleEJB;
import com.train.newtask.entity.SimpleSchedule;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "scheduleBean")
@SessionScoped
public class ScheduleController implements Serializable
{
    @Inject
    private Logger logger;

    @EJB
    private ScheduleEJB scheduleEJB;


    private List<SimpleSchedule> oneStationScheduleList=new ArrayList<>();

    private List<String> stationList=new ArrayList<>();


    public List<SimpleSchedule> getOneStationScheduleList() {
        return oneStationScheduleList;
    }

    public List<String> getStationList() throws JMSException {

        stationList=scheduleEJB.getAllStations();
        return stationList;
    }


    public String getOneStationList(String station) throws JMSException {

        oneStationScheduleList=scheduleEJB.getLstFromStation(station);
        logger.info("################ run ScheduleController-> getOneStationScheduleList");
        return "home.xhtml";
    }









}
