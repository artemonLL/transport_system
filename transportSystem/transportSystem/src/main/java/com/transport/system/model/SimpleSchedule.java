package com.transport.system.model;

import java.sql.Timestamp;

public class SimpleSchedule
{

    private String station;

    private String train;

    private Timestamp time;


    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
