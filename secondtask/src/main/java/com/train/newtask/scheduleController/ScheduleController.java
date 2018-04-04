package com.train.newtask.scheduleController;

import com.train.newtask.EJB.ScheduleEJB;
import com.train.newtask.entity.SimpleSchedule;

import javax.ejb.EJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;


import javax.jms.JMSException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "scheduleBean")
@RequestScoped
public class ScheduleController implements Serializable
{

    @EJB
    private ScheduleEJB scheduleEJB;


    private List<SimpleSchedule> oneStationScheduleList=new ArrayList<>();

    private List<String> stationList=new ArrayList<>();

    private String current_station;

    public String getCurrent_station() {
        return current_station;
    }

    public List<SimpleSchedule> getOneStationScheduleList() {
        return oneStationScheduleList;
    }

    public List<String> getStationList() throws JMSException {
        stationList=scheduleEJB.getAllStations();
        return stationList;
    }


    public String getOneStationList(String station) throws JMSException {

        scheduleEJB.updateListFromDefStation(station);
        oneStationScheduleList=scheduleEJB.getOneStationScheduleList();
        current_station=station;
       // logger.info("################ run ScheduleController-> getOneStationScheduleList");
        return "home.xhtml";
    }









}
