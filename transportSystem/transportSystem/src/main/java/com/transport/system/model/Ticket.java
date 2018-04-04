package com.transport.system.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * Simple JavaBean  object that represents a Ticket
 * */
    @Entity

    @Proxy(lazy=false)
    @Table(name = "ticket")
    public class Ticket {

        @Id
        @Column(name = "ticket_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer ticket_id;


        @ManyToOne
        @JoinColumn (name = "departure_station_id")
        private Station departure_station_id;


        @ManyToOne
        @JoinColumn (name = "arrival_station_id")
        private Station arrival_station_id;

        @ManyToOne
        @JoinColumn (name = "user_id")
        private User user_id;


        @ManyToOne
        @JoinColumn (name = "train_id")
        private Train train_id;


        @Column(name = "time")
        private Timestamp departDateTime;

    public Timestamp getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(Timestamp departDateTime) {
        this.departDateTime = departDateTime;
    }

    public Integer getTicket_id() {
            return ticket_id;
        }

        public void setTicket_id(Integer ticket_id) {
            this.ticket_id = ticket_id;
        }

        public Station getDeparture_station_id() {
            return departure_station_id;
        }

        public void setDeparture_station_id(Station departure_station_id) {
            this.departure_station_id = departure_station_id;
        }

        public Station getArrival_station_id() {
            return arrival_station_id;
        }

        public void setArrival_station_id(Station arrival_station_id) {
            this.arrival_station_id = arrival_station_id;
        }

        public User getUser_id() {
            return user_id;
        }

        public void setUser_id(User user_id) {
            this.user_id = user_id;
        }

        public Train getTrain_id() {
            return train_id;
        }

        public void setTrain_id(Train train_id) {
            this.train_id = train_id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Ticket ticket = (Ticket) o;

            if (ticket_id != null ? !ticket_id.equals(ticket.ticket_id) : ticket.ticket_id != null) return false;
            if (departure_station_id != null ? !departure_station_id.equals(ticket.departure_station_id) : ticket.departure_station_id != null)
                return false;
            if (arrival_station_id != null ? !arrival_station_id.equals(ticket.arrival_station_id) : ticket.arrival_station_id != null)
                return false;
            if (user_id != null ? !user_id.equals(ticket.user_id) : ticket.user_id != null) return false;
            return train_id != null ? train_id.equals(ticket.train_id) : ticket.train_id == null;
        }

        @Override
        public int hashCode() {
            int result = ticket_id != null ? ticket_id.hashCode() : 0;
            result = 31 * result + (departure_station_id != null ? departure_station_id.hashCode() : 0);
            result = 31 * result + (arrival_station_id != null ? arrival_station_id.hashCode() : 0);
            result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
            result = 31 * result + (train_id != null ? train_id.hashCode() : 0);
            return result;
        }
    }
