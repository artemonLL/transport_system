package com.transport.system.model;

import java.sql.Timestamp;

public class BuyTicketForm {


    private int departure_station_id;

    private int arrival_station_id;

    private int train_id;

    private Timestamp departDateTime;

    public Timestamp getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(Timestamp departDateTime) {
        this.departDateTime = departDateTime;
    }

    public int getDeparture_station_id() {
        return departure_station_id;
    }

    public void setDeparture_station_id(int departure_station_id) {
        this.departure_station_id = departure_station_id;
    }

    public int getArrival_station_id() {
        return arrival_station_id;
    }

    public void setArrival_station_id(int arrival_station_id) {
        this.arrival_station_id = arrival_station_id;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
}
