package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.StationService;
import com.transport.system.service.TrainService;
import com.transport.system.service.TrainServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;


@Repository
public class ScheduleDaoIml implements ScheduleDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;


    private static final Logger logr = Logger.getLogger(ScheduleDaoIml.class);


    @Override
    public Schedule getScheduleById(int schedule_id) {
        Schedule schedule = new Schedule();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            schedule = (Schedule) session.load(Schedule.class, new Integer(schedule_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        try {
            Train train = trainService.getTrainById(schedule.getTrain().getTrain_id());
            schedule.setTrain(train);
            Session session = this.sessionFactory.getCurrentSession();
            session.save(schedule);

            logr.warn("ADD SCHEDULE with TRAIN-" + schedule.getTrain().getTrain_number() + " and STATION " +
                    schedule.getStation().getStation_name() + " and TIME- " + schedule.getTime_msk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateSchedule(Schedule schedule) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> getScheduleList() {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            scheduleList = session.createQuery("from Schedule").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getScheduleByTrainId(int train_id) {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria scheduleCriteria = session.createCriteria(Schedule.class);
            scheduleCriteria.add(Restrictions.eq("train", trainService.getTrainById(train_id)));
            scheduleList = scheduleCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scheduleList;

    }

    @Override
    public List<Schedule> getScheduleListByStation(int station_id) {

        List<Schedule> scheduleList = new ArrayList<>();
        try {
            logr.warn("-----------------getScheduleListByStation -----station_id--- " + station_id);
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(Schedule.class);
            userCriteria.add(Restrictions.eq("station", stationService.getStationById(station_id)));
            scheduleList = userCriteria.list();
            logr.warn("-----------------getScheduleListByStation -----scheduleList--- " + scheduleList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scheduleList;
    }



/*
    @Override
    public List<Station> getTrainListFromStation(int station_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria stationCriteria=session.createCriteria(Schedule.class);
        stationCriteria.add(Restrictions.eq("station",stationService.getStationById(station_id)));
        List<Station> trainFromstationList =stationCriteria.list();
        return trainFromstationList;
    }
*/

    @Override
    public List<Schedule> selectByDatesAndStations(Timestamp dateOne, Timestamp dateTwo, int stationOne, int stationTwo) {
        Timestamp timestamp1 = dateOne;
        Timestamp timestamp2 = dateTwo;


        Session session = this.sessionFactory.getCurrentSession();


        List<Schedule> list1 = new ArrayList<>();
        try {
            String queryString1 = " from Schedule   where station.station_id= :stationTwo and time_msk >  :dateOne ";
            Query query1 = session.createQuery(queryString1);
            query1.setParameter("stationTwo", stationTwo);
            query1.setParameter("dateOne", dateOne);
            list1 = query1.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "";
        boolean flag = true;
        for (Schedule schedule : list1) {
            if (flag == false)
                str = str + ",";
            str = str + schedule.getTrain().getTrain_id();
            flag = false;
        }


        logr.warn(String.format("----LIIIISSSSST 2222" + list1.size()));

       /* String queryString2 = " from Schedule  where time_msk >= :dateOne and time_msk <= :dateTwo  AND station.station_id= :stationOneId" +
                " AND train.train_id in("+str+")" ;
        Query query=session.createQuery(queryString);
        query.setParameter("dateOne",timestamp1);
        query.setParameter("dateTwo",timestamp2);
        query.setParameter("stationOneId",stationOne);

        List <Schedule> list=query.list();
*/

        List<Schedule> nullScheduleList = new ArrayList<>();
        if (str == "") {
            return nullScheduleList;
        }
        List<Schedule> list = new ArrayList<>();
        try {
            String queryString = " from Schedule  where time_msk >= :dateOne and time_msk <= :dateTwo  AND station.station_id= :stationOneId" +
                    " AND train.train_id in(" + str + ")";
            Query query = session.createQuery(queryString);
            query.setParameter("dateOne", timestamp1);
            query.setParameter("dateTwo", timestamp2);
            query.setParameter("stationOneId", stationOne);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Schedule> list_finall = new ArrayList<>();

        //Date date=new

        java.util.Date date=new java.util.Date();

        for (int i = 0; i < list.size(); i++) {
            for (Schedule schedule : list1) {
                if (schedule.getTrain() == list.get(i).getTrain()) {
                    if (schedule.getTime_msk().after(list.get(i).getTime_msk())) {
                        if (list.get(i).getTrain().getPlaces() > 0) {
                            if (list.get(i).getTime_msk().getTime()>date.getTime()+600000) {
                                list_finall.add(list.get(i));
                            }
                        }
                    }
                }
            }
        }

        return list_finall;
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



