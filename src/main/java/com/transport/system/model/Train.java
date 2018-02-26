package com.transport.system.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;



@Entity
@Proxy(lazy=false)
@Table(name = "train")
public class Train
{
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int train_id;



    @Column(name = "train_nomber")
    private String train_nomber;

    @Column(name = "places")
    private int places;


    @Override
    public String toString() {
        return "Train{" +
                "train_id=" + train_id +
                ", train_nomber='" + train_nomber + '\'' +
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
        return train_nomber;
    }

    public void setTrain_nomber(String train_nomber) {
        this.train_nomber = train_nomber;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}



