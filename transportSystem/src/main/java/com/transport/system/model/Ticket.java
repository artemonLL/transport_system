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


}
