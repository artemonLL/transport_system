package com.transport.system.dao;

import com.transport.system.model.Ticket;
import com.transport.system.model.Train;
import com.transport.system.model.User;

import java.util.List;

public interface TicketDao

{

    public List<Ticket> getTicketListsByUser(User user);

    public void addTicket(Ticket ticket);

    public List<User> getUserListFromTrain(Train train);


}
