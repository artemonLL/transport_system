package com.transport.system.service;

import com.transport.system.model.Ticket;
import com.transport.system.model.Train;
import com.transport.system.model.User;

import java.util.List;

public interface TicketService {


    /**
     * Returns all Ticket from database by user.
     * @param user User entity in the  database.
     *                 @return List<Ticket>.
     **/
    public List<Ticket> getTicketListsByUser(User user);

    /**
     * Add Ticket to database.
     * @param ticket Ticket entity.
     *                 @return void.
     **/
    public void addTicket(Ticket ticket);

    /**
     * Returns all Users from database by train.
     * @param train Train entity in the database.
     *                 @return List<Ticket>.
     **/
    public List<User> getUserListFromTrain(Train train);


}
