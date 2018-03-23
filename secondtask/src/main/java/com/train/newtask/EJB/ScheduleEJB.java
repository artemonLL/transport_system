package com.train.newtask.EJB;


import com.train.newtask.entity.Schedule;
import com.train.newtask.entity.SimpleSchedule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ScheduleEJB
{

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;



    public List<SimpleSchedule> getAllSchedule() {

        List<SimpleSchedule> simpleScheduleList=new ArrayList<>();
        simpleScheduleList=new UpdateListener().start();



        return simpleScheduleList;
    }

}
