package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.messaging.MessageSender;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.ScheduleService;
import com.transport.system.service.StationService;
import com.transport.system.service.TrainService;
import com.transport.system.service.TrainServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
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


    /**
     * Get Schedule by ID  method returns Schedule from database
     * by ID. Method search Schedule from Schedule table.
     * @param schedule_id Schedule ID.
     * @return Schedule entity
     * */
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

    /**
     * Remove cheduleS by ID remove Schedule from database by ID.
     * Method remove Schedule from Schedule table.
     * @param schedule_id Schedule ID.
     * @return void.
     * */
    @Override
    public boolean removeSchedule(int schedule_id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Schedule schedule = (Schedule) session.load(Schedule.class, new Integer(schedule_id));
            if (schedule != null) {
                session.delete(schedule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Add Schedule by schedule method add Schedule to database
     * by schedule entity.
     * Method add Schedule to schedule table.
     * @param schedule the Schedule entity.
     * @return void.
     * */
    @Override
    public boolean addSchedule(Schedule schedule) {
        try {
            Train train = trainService.getTrainById(schedule.getTrain().getTrain_id());
            Station station = stationService.getStationById(schedule.getStation().getStation_id());
            schedule.setTrain(train);
            schedule.setStation(station);
            Session session = this.sessionFactory.getCurrentSession();
            session.save(schedule);
            logr.info("ADD SCHEDULE with TRAIN-" + schedule.getTrain().getTrain_number() + " and STATION " +
                    schedule.getStation().getStation_name() + " and TIME- " + schedule.getTime_msk());
        } catch (Exception e) {
            e.printStackTrace();
        }
return true;

    }


    /**
     * Update Schedule method update Schedule at database
     * by schedule entity.
     * Method update Schedule at schedule table.
     * @param schedule the Schedule entity.
     * @return void.
     * */

    @Override
    public boolean updateSchedule(Schedule schedule) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.flush();
            session.clear();
          session.update(schedule);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Get Schedule List method return List<Schedule> from database.
     * Method return List<Schedule> from schedule table.
     * @return List<Schedule>.
     * */
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

    /**
     * Get Schedule by Train ID  method returns List<Schedule> from database
     * by Train ID. Method get List<Schedule> from Schedule table.
     * @param train_id  Train ID.
     * @return List<Schedule> .
     * */
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

    /**
     * Get Schedule by Station method returns List<Schedule> from database
     * by Station ID. Method get List<Schedule> from Schedule table.
     * @param station_id  Station ID .
     * @return List<Schedule> .
     * */
    @Override
    public List<Schedule> getScheduleListByStation(int station_id) {

        List<Schedule> scheduleList = new ArrayList<>();
        try {
            logr.info("-----------------getScheduleListByStation -----station_id--- " + station_id);
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(Schedule.class);
            userCriteria.add(Restrictions.eq("station", stationService.getStationById(station_id)));
            scheduleList = userCriteria.list();
            logr.info("-----------------getScheduleListByStation -----scheduleList--- " + scheduleList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scheduleList;
    }


    /**
     * Select by Dates and Station method returns List<Schedule> from database
     * by between date One and date Two,and where Train follow from stationOne ID to stationTwo ID. Method get List<Schedule> from Schedule table.
     * @param dateOne the first date in Schedule.
     * @param dateTwo the second date in Schedule.
     * @param stationOne  the ID of the departure station in the Schedule.
     * @param dateTwo  second date in Schedule.
     * @return List<Schedule> .
     * */

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
        java.util.Date date = new java.util.Date();

        for (int i = 0; i < list.size(); i++) {
            for (Schedule schedule : list1) {
                if (schedule.getTrain() == list.get(i).getTrain()) {
                    if (schedule.getTime_msk().after(list.get(i).getTime_msk())) {
                        if (list.get(i).getTrain().getPlaces() > 0) {
                            if (list.get(i).getTime_msk().getTime() > date.getTime() + 600000) {
                                list_finall.add(list.get(i));
                            }
                        }
                    }
                }
            }
        }

        return list_finall;
    }
}



