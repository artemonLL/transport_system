package com.train.newtask.entity;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;


@XmlRootElement
public class SimpleSchedule
{

    private String station;

    private String train;

    private Timestamp time;

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
