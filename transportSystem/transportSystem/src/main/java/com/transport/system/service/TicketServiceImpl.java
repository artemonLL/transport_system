package com.transport.system.service;


import com.transport.system.dao.TicketDao;
import com.transport.system.model.Ticket;
import com.transport.system.model.Train;
import com.transport.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Service
@Transactional
public class TicketServiceImpl implements TicketService
{

    @Autowired
    private  TicketDao ticketDao;

    @Override
    public List<Ticket> getTicketListsByUser(User user) {
        return this.ticketDao.getTicketListsByUser(user);
    }

    @Override
    public void addTicket(Ticket ticket) {
        this.ticketDao.addTicket(ticket);
    }

    @Override
    public List<User> getUserListFromTrain(Train train) {
        return this.ticketDao.getUserListFromTrain(train);
    }
}
