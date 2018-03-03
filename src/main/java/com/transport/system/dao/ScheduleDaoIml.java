package com.transport.system.dao;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.TrainService;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;


@Repository
public class ScheduleDaoIml implements ScheduleDao{


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TrainService trainService;

  //  private static final Logger logger = LogManager.getLogger(ScheduleDaoIml.class);


    @Override
    public Schedule getScheduleById(int schedule_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Schedule schedule=(Schedule)session.load(Schedule.class,new Integer(schedule_id));
        return schedule;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        Train train=trainService.getTrainById(schedule.getTrain().getTrain_id());
        schedule.setTrain(train);
        Session session=this.sessionFactory.getCurrentSession();
        session.save(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {

        Session session=this.sessionFactory.getCurrentSession();
        session.update(schedule);
    }

    @Override
    public List<Schedule> getScheduleList() {
        Session session=this.sessionFactory.getCurrentSession();
        List<Schedule> scheduleList= session.createQuery("from Schedule").list();
        return scheduleList;
    }



    @Override
    public List<Schedule> selectByDatesAndStations(Time dateOne, Time dateTwo, Date date, int stationOne, int stationTwo) {
 Timestamp timestamp1=new Timestamp(date.getTime()+dateOne.getTime());
 Timestamp timestamp2=new Timestamp(date.getTime()+dateTwo.getTime());


/*
        Calendar cal1=Calendar.getInstance();
        cal1.set(2000,10,10);
        Calendar cal2=Calendar.getInstance();
        cal2.set(2006,10,10);
        Date date1=new Date(cal1.getTimeInMillis());

        Date date2=new Date(cal2.getTimeInMillis());
*/


        Session session=this.sessionFactory.getCurrentSession();
        String queryString1 = " from Schedule   where station.station_id= :stationTwo";
        Query query1=session.createQuery(queryString1);
        query1.setParameter("stationTwo",stationTwo);
        List<Schedule> list1=query1.list();
        String str="";
        boolean flag=true;
        for(Schedule schedule:list1) {
            if(flag==false)
            str=str+",";
            str=str+schedule.getTrain().getTrain_id();
            flag=false;
        }

 String queryString = " from Schedule  where time_msk >= :dateOne and time_msk <= :dateTwo  AND station.station_id= :stationOneId" +
         " AND train.train_id in("+str+")" ;
     Query query=session.createQuery(queryString);
     query.setParameter("dateOne",timestamp1);
        query.setParameter("dateTwo",timestamp2);
        query.setParameter("stationOneId",stationOne);

        List <Schedule> list=query.list();

   //     logger.info(String.format("Successfully %s auto logged in",list));

        return list;
    }

  /*  @Override
    public List<Schedule> selectByDatesAndStations(Date dateOne, Date dateTwo, int stationOne, int stationTwo) {

        Session session=this.sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery("SELECT * FROM schedule WHERE time_msk > :dateOne AND time_msk < :dateTwo " +
                "AND station.station_id = :stationOneId AND train.train_id in(SELECT train.train_id FROM schedule" +
                " WHERE station.station_id = :stationTwo)");
        query.setParameter("dateOne",dateOne);
        query.setParameter("dateTwo",dateTwo);
        query.setParameter("stationOneId",stationOne);
        query.setParameter("stationTwo",stationTwo);
        List list=query.list();
        return list;  }*/



}



