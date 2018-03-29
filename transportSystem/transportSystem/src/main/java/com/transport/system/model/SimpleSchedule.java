package com.transport.system.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SimpleSchedule implements Serializable
{

    private String station;

    private String train;

    private Timestamp time;

    private int platform;

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "SimpleSchedule{" +
                "station='" + station + '\'' +
                ", train='" + train + '\'' +
                ", time=" + time +
                '}';
    }

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
