package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.model.Schedule;
import com.transport.system.model.Ticket;
import com.transport.system.model.Train;
import com.transport.system.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;


    private static final Logger logr = Logger.getLogger(TrainStationScheduleController.class);
    @Transactional
    @Override
    public List<Ticket> getTicketListsByUser(User user) {

        logr.warn(String.format("----------getTicketListsByUser LIST user name "+user.getUsername()));
        Session session=this.sessionFactory.getCurrentSession();
        Criteria ticketCriteria=session.createCriteria(Ticket.class);
        ticketCriteria.add(Restrictions.eq("user_id",user));
        List<Ticket> ticketList=ticketCriteria.list();
        logr.warn(String.format("----------getTicketListsByUser LIST "+ticketList.size()));
        return ticketList;

    }
    @Transactional
    @Override
    public void addTicket(Ticket ticket) {

        Session session=this.sessionFactory.getCurrentSession();

        session.persist(ticket);
    }
    @Transactional
    @Override
    public List<User> getUserListFromTrain(Train train) {

        logr.warn(String.format("-----------getUserListFromTrain "+train.getTrain_number()));
            Session session=this.sessionFactory.getCurrentSession();
            Criteria ticketCriteria=session.createCriteria(Ticket.class);
            ticketCriteria.add(Restrictions.eq("train_id",train));
            List<Ticket> ticketList=ticketCriteria.list();
            List<User> userList=new ArrayList<>();
        logr.warn(String.format("----------TICKETlist size "+ticketList.size()));
            for(Ticket ticket:ticketList)
            {
                if(!userList.contains(ticket.getUser_id())) {
                    userList.add(ticket.getUser_id());
                }
            }
        logr.warn(String.format("----------USERlist size "+userList.size()));
            return userList;



    }









/*
    Session session=this.sessionFactory.getCurrentSession();
    String queryString1 = " from Schedule   where station.station_id= :stationTwo AND time_msk > :timestamp2";
    Query query1=session.createQuery(queryString1);
        query1.setParameter("stationTwo",stationTwo);
      query1.setParameter("timestamp2",timestamp2);
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

        if(list!=null) {
        logr.warn(String.format("----FIND THIS STATIONS-------", list));
        logr.warn(String.format("----FIND THIS STATIONS-------", list));
    }
        else
    {
        logr.warn(String.format("-----------LIST NUUULLL---------------"));
        logr.warn(String.format("-----------LIST NUUULLL-----------------"));
    }
        return list;


    */




}
