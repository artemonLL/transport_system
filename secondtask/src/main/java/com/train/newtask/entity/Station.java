package com.train.newtask.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;


@XmlRootElement
@Entity
@Table(name = "station")
public class Station implements Serializable{


    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int station_id;


    @Column(name = "station_name")
    private String station_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (station_id != station.station_id) return false;
        return station_name != null ? station_name.equals(station.station_name) : station.station_name == null;
    }

    @Override
    public int hashCode() {
        int result = station_id;
        result = 31 * result + (station_name != null ? station_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Station{" +
                "station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                '}';
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
}