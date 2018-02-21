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
