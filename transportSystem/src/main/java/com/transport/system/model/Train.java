package com.transport.system.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;

/**
 * Simple object that represents a Train
 */

@Entity
@Proxy(lazy=false)
@Table(name = "train")
public class Train implements Serializable
{
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int train_id;



    @Column(name = "train_number")
    private String train_number;


    @Column(name = "places")
    private int places;


    public static final Comparator<Train> COMPARE_BY_ID = new Comparator<Train>() {
        @Override
        public int compare(Train lhs, Train rhs) {
            return   rhs.getTrain_id()-lhs.getTrain_id();
        }
    };


    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }


    @Override
    public String toString() {
        return train_number;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }


    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}



