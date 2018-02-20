package com.transport.system.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Schedule {
    private Integer scheduleId;
    private Integer trainId;
    private Integer stationId;
    private Timestamp timeMsk;
    private Integer freePlaces;
    private Integer wayPosition;
    private Train trainByTrainId;
    private Station stationByStationId;

    @Id
    @Column(name = "schedule_id", nullable = false)
    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Basic
    @Column(name = "train_id", nullable = false)
    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "station_id", nullable = false)
    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "time_msk", nullable = false)
    public Timestamp getTimeMsk() {
        return timeMsk;
    }

    public void setTimeMsk(Timestamp timeMsk) {
        this.timeMsk = timeMsk;
    }

    @Basic
    @Column(name = "free_places", nullable = false)
    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Basic
    @Column(name = "way_position", nullable = false)
    public Integer getWayPosition() {
        return wayPosition;
    }

    public void setWayPosition(Integer wayPosition) {
        this.wayPosition = wayPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (scheduleId != null ? !scheduleId.equals(schedule.scheduleId) : schedule.scheduleId != null) return false;
        if (trainId != null ? !trainId.equals(schedule.trainId) : schedule.trainId != null) return false;
        if (stationId != null ? !stationId.equals(schedule.stationId) : schedule.stationId != null) return false;
        if (timeMsk != null ? !timeMsk.equals(schedule.timeMsk) : schedule.timeMsk != null) return false;
        if (freePlaces != null ? !freePlaces.equals(schedule.freePlaces) : schedule.freePlaces != null) return false;
        if (wayPosition != null ? !wayPosition.equals(schedule.wayPosition) : schedule.wayPosition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId != null ? scheduleId.hashCode() : 0;
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        result = 31 * result + (stationId != null ? stationId.hashCode() : 0);
        result = 31 * result + (timeMsk != null ? timeMsk.hashCode() : 0);
        result = 31 * result + (freePlaces != null ? freePlaces.hashCode() : 0);
        result = 31 * result + (wayPosition != null ? wayPosition.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "train_id", nullable = false)
    public Train getTrainByTrainId() {
        return trainByTrainId;
    }

    public void setTrainByTrainId(Train trainByTrainId) {
        this.trainByTrainId = trainByTrainId;
    }

    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "station_id", nullable = false)
    public Station getStationByStationId() {
        return stationByStationId;
    }

    public void setStationByStationId(Station stationByStationId) {
        this.stationByStationId = stationByStationId;
    }
}
