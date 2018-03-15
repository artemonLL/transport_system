package com.train.newtask.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "train")
public class Train implements Serializable{

    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (train_id != train.train_id) return false;
        if (places != train.places) return false;
        return train_number != null ? train_number.equals(train.train_number) : train.train_number == null;
    }

    @Override
    public int hashCode() {
        int result = train_id;
        result = 31 * result + (train_number != null ? train_number.hashCode() : 0);
        result = 31 * result + places;
        return result;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}

