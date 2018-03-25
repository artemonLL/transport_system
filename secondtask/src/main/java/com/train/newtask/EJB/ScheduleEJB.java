package com.train.newtask.EJB;


import com.train.newtask.entity.SimpleSchedule;


import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateful
@SessionScoped
public class ScheduleEJB
{

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    UpdateListener updateListener =new UpdateListener();


    public List<String> getAllStations() throws JMSException {

        List<SimpleSchedule> fullsimpleScheduleList=new ArrayList<>();
        fullsimpleScheduleList=updateListener.start();
        List<String> allStations=new ArrayList<>();
        for(SimpleSchedule simpleSchedule:fullsimpleScheduleList)
        {
            if(!allStations.contains(simpleSchedule.getStation()))
            {
                allStations.add(simpleSchedule.getStation());
            }
        }
        return allStations;
    }

    public List<SimpleSchedule> getLstFromStation(String station) throws JMSException {

        List<SimpleSchedule> fullsimpleScheduleList = new ArrayList<>();
        List<SimpleSchedule> oneStationScheduleList = new ArrayList<>();
        fullsimpleScheduleList = updateListener.start();

        for (SimpleSchedule simpleSchedule:fullsimpleScheduleList)
        {
            if(simpleSchedule.getStation().equals(station))
            {
                oneStationScheduleList.add(simpleSchedule);
            }
        }
        logger.info("ScheduleEJB->getLstFromStation->"+station+" size ="+oneStationScheduleList.size());
        return oneStationScheduleList;
    }

}
