package com.transport.system.model;

import javax.persistence.*;

@Entity
public class Ticket {
    private Integer ticketId;
    private Integer departureStationId;
    private Integer arrivalStationId;
    private Integer userId;
    private Integer trainId;
    private Station stationByDepartureStationId;
    private Station stationByArrivalStationId;
    private User userByUserId;
    private Train trainByTrainId;

    @Id
    @Column(name = "ticket_id", nullable = false)
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "departure_station_id", nullable = false)
    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
    }

    @Basic
    @Column(name = "arrival_station_id", nullable = false)
    public Integer getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(Integer arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "train_id", nullable = false)
    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != null ? !ticketId.equals(ticket.ticketId) : ticket.ticketId != null) return false;
        if (departureStationId != null ? !departureStationId.equals(ticket.departureStationId) : ticket.departureStationId != null)
            return false;
        if (arrivalStationId != null ? !arrivalStationId.equals(ticket.arrivalStationId) : ticket.arrivalStationId != null)
            return false;
        if (userId != null ? !userId.equals(ticket.userId) : ticket.userId != null) return false;
        if (trainId != null ? !trainId.equals(ticket.trainId) : ticket.trainId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (departureStationId != null ? departureStationId.hashCode() : 0);
        result = 31 * result + (arrivalStationId != null ? arrivalStationId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "departure_station_id", referencedColumnName = "station_id", nullable = false)
    public Station getStationByDepartureStationId() {
        return stationByDepartureStationId;
    }

    public void setStationByDepartureStationId(Station stationByDepartureStationId) {
        this.stationByDepartureStationId = stationByDepartureStationId;
    }

    @ManyToOne
    @JoinColumn(name = "arrival_station_id", referencedColumnName = "station_id", nullable = false)
    public Station getStationByArrivalStationId() {
        return stationByArrivalStationId;
    }

    public void setStationByArrivalStationId(Station stationByArrivalStationId) {
        this.stationByArrivalStationId = stationByArrivalStationId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "train_id", nullable = false)
    public Train getTrainByTrainId() {
        return trainByTrainId;
    }

    public void setTrainByTrainId(Train trainByTrainId) {
        this.trainByTrainId = trainByTrainId;
    }
}
