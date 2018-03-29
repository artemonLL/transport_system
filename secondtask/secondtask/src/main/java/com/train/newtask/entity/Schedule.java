package com.train.newtask.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;



@XmlRootElement
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedule_id;


    @ManyToOne(targetEntity = Train.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "train_id")
    private Train train;



    @ManyToOne(targetEntity = Station.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "station_id")
    private Station station;



    @Column(name = "time_msk")
    private Timestamp time_msk;

    @Column(name = "way_position")
    private int way_position;

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", schedule_id=" + schedule_id +
                ", train=" + train +
                ", station=" + station +
                ", time_msk=" + time_msk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (schedule_id != schedule.schedule_id) return false;
        if (schedule_id != schedule.schedule_id) return false;
        if (train != null ? !train.equals(schedule.train) : schedule.train != null) return false;
        if (station != null ? !station.equals(schedule.station) : schedule.station != null) return false;
        return time_msk != null ? time_msk.equals(schedule.time_msk) : schedule.time_msk == null;
    }

    @Override
    public int hashCode() {
        int result = schedule_id;
        result = 31 * result + schedule_id;
        result = 31 * result + (train != null ? train.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        result = 31 * result + (time_msk != null ? time_msk.hashCode() : 0);
        return result;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
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

    public Timestamp getTime_msk() {
        return time_msk;
    }

    public void setTime_msk(Timestamp time_msk) {
        this.time_msk = time_msk;
    }
}