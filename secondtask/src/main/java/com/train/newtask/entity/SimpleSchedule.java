package com.train.newtask.entity;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Simple object that represents a Schedule.
 */
@XmlRootElement
public class SimpleSchedule implements Serializable
{
    /**
     * Station name
     */
    private String station;
    /**
     * Train number
     */
    private String train;
    /**
     * Time
     */
    private Timestamp time;
    /**
     * Platform where train will stay.
     */
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
