package com.transport.system.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Proxy(lazy=false)
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedule_id;


    @ManyToOne
    @JoinColumn (name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn (name = "station_id")
    private Station station;

    @Column(name = "time_msk")
    private Date time_msk;

    @Column(name = "way_position")
    private int way_position;

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", train="  +
                ", station=" +

                ", way_position=" + way_position +
                '}';
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Date getTime_msk() {
        return time_msk;
    }

    public void setTime_msk(Date time_msk) {
        this.time_msk = time_msk;
    }


    public int getWay_position() {
        return way_position;
    }

    public void setWay_position(int way_position) {
        this.way_position = way_position;
    }
}
