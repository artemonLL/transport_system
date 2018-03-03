package com.transport.system.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "train")
public class Train
{
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int train_id;



    @Column(name = "train_number")
    private String train_number;

    @Column(name = "places")
    private int places;



    @Override
    public String toString() {
        return "Train{" +
                "train_id=" + train_id +
                ", train_number='" + train_number + '\'' +
                ", places=" + places +
                '}';
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getTrain_nomber() {
        return train_number;
    }

    public void setTrain_nomber(String train_nomber) {
        this.train_number = train_nomber;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}



