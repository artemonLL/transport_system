package com.transport.system.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

/**
 * Simple JavaBean  object that represents a Station
 * */
@Entity
@Proxy(lazy=false)
@Table(name = "station")
public class Station implements Serializable {


    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int station_id;


    @Column(name = "station_name")
    private String station_name;

    public static final Comparator<Station> COMPARE_BY_ID = new Comparator<Station>() {
        @Override
        public int compare(Station lhs, Station rhs) {
            return   rhs.getStation_id()-lhs.getStation_id();
        }
    };


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

    @Override
    public String toString() {
        return "Station{" +
                "station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                '}';
    }
}