package com.transport.system.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Station {
    private Integer stationId;
    private String name;
    private Collection<Schedule> schedulesByStationId;
    private Collection<Ticket> ticketsByStationId;
    private Collection<Ticket> ticketsByStationId_0;

    @Id
    @Column(name = "station_id", nullable = false)
    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (stationId != null ? !stationId.equals(station.stationId) : station.stationId != null) return false;
        if (name != null ? !name.equals(station.name) : station.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stationId != null ? stationId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stationByStationId")
    public Collection<Schedule> getSchedulesByStationId() {
        return schedulesByStationId;
    }

    public void setSchedulesByStationId(Collection<Schedule> schedulesByStationId) {
        this.schedulesByStationId = schedulesByStationId;
    }

    @OneToMany(mappedBy = "stationByDepartureStationId")
    public Collection<Ticket> getTicketsByStationId() {
        return ticketsByStationId;
    }

    public void setTicketsByStationId(Collection<Ticket> ticketsByStationId) {
        this.ticketsByStationId = ticketsByStationId;
    }

    @OneToMany(mappedBy = "stationByArrivalStationId")
    public Collection<Ticket> getTicketsByStationId_0() {
        return ticketsByStationId_0;
    }

    public void setTicketsByStationId_0(Collection<Ticket> ticketsByStationId_0) {
        this.ticketsByStationId_0 = ticketsByStationId_0;
    }
}
