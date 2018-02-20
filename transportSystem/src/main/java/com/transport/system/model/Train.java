package com.transport.system.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Train {
    private Integer trainId;
    private String trainNomber;
    private Integer places;
    private Collection<Schedule> schedulesByTrainId;
    private Collection<Ticket> ticketsByTrainId;

    @Id
    @Column(name = "train_id", nullable = false)
    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "train_nomber", nullable = false, length = 30)
    public String getTrainNomber() {
        return trainNomber;
    }

    public void setTrainNomber(String trainNomber) {
        this.trainNomber = trainNomber;
    }

    @Basic
    @Column(name = "places", nullable = false)
    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (trainId != null ? !trainId.equals(train.trainId) : train.trainId != null) return false;
        if (trainNomber != null ? !trainNomber.equals(train.trainNomber) : train.trainNomber != null) return false;
        if (places != null ? !places.equals(train.places) : train.places != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainId != null ? trainId.hashCode() : 0;
        result = 31 * result + (trainNomber != null ? trainNomber.hashCode() : 0);
        result = 31 * result + (places != null ? places.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainByTrainId")
    public Collection<Schedule> getSchedulesByTrainId() {
        return schedulesByTrainId;
    }

    public void setSchedulesByTrainId(Collection<Schedule> schedulesByTrainId) {
        this.schedulesByTrainId = schedulesByTrainId;
    }

    @OneToMany(mappedBy = "trainByTrainId")
    public Collection<Ticket> getTicketsByTrainId() {
        return ticketsByTrainId;
    }

    public void setTicketsByTrainId(Collection<Ticket> ticketsByTrainId) {
        this.ticketsByTrainId = ticketsByTrainId;
    }
}
