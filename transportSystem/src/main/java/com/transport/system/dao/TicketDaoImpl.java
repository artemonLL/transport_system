package com.transport.system.dao;

import com.transport.system.controller.TrainStationScheduleController;
import com.transport.system.model.Schedule;
import com.transport.system.model.Ticket;
import com.transport.system.model.Train;
import com.transport.system.model.User;
import com.transport.system.service.UserService;
import com.transport.system.service.UserServiceImpl;
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

    @Autowired
    private UserService userService;

    private static final Logger logr = Logger.getLogger(TicketDaoImpl.class);

    /**
     * Get Ticket List by User method returns List<Ticket> from database
     * by user. Method returns List<Ticket> from ticket table.
     * @param user user entity.
     * @return List<Ticket>.
     * */
    @Transactional
    @Override
    public List<Ticket> getTicketListsByUser(User user) {
        List<Ticket> ticketList=new ArrayList<>();
        try {
        logr.info(String.format("----------getTicketListsByUser LIST user name " + user.getUsername()));
        Session session = this.sessionFactory.getCurrentSession();
        Criteria ticketCriteria = session.createCriteria(Ticket.class);
        ticketCriteria.add(Restrictions.eq("user_id", user));
        ticketList = ticketCriteria.list();
        logr.info(String.format("----------getTicketListsByUser LIST " + ticketList.size()));
    } catch (Exception e) {
        e.printStackTrace();
    }
        return ticketList;

    }

    /**
     * Add Ticket method adds Ticket to database.
     * Method add ticket to ticket table.
     * @param ticket ticket entity.
     * @return void.
     * */
    @Transactional
    @Override
    public void addTicket(Ticket ticket) {

        try {
            Session session = this.sessionFactory.getCurrentSession();

            session.persist(ticket);
            logr.info(("BUY TICKET with DEPARTURE STATION " + ticket.getDeparture_station_id() + " FOR USER " + ticket.getUser_id().getUsername()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get User List From Train  method returns user List<User> from database
     * by train . Method returns List<User> from user table.
     * @param train train entity.
     * @return List<User>.
     * */
    @Transactional
    @Override
    public List<User> getUserListFromTrain(Train train) {

        List<User> userList = new ArrayList<>();
        try {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria ticketCriteria = session.createCriteria(Ticket.class);
        ticketCriteria.add(Restrictions.eq("train_id", train));
        List<Ticket> ticketList = ticketCriteria.list();
        userList = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (!userList.contains(ticket.getUser_id())) {
                userList.add(ticket.getUser_id());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return userList;
    }
}
