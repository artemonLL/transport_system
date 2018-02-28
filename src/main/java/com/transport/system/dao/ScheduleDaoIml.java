package com.transport.system.dao;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.TrainService;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ScheduleDaoIml implements ScheduleDao{


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TrainService trainService;

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
    public Schedule getScheduleByTrainId(int train_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Schedule where train_id = ?");
        query.setInteger(0,train_id);
        session.flush();
        return (Schedule)query.uniqueResult();
    }
}



