package com.transport.system.service;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

import java.sql.Date;
import java.util.List;

public interface StationService {

    /**
     * Returns Station from database by station's id.
     * @param station_id station's id in the database.
     *                 @return Station obj.
     **/
    public Station getStationById(int station_id) ;

    /**
     * Returns Station from database by station's name.
     * @param station_name station's name in the database.
     *                 @return Station obj.
     **/
    public Station getStationByName(String station_name);

    /**
     * Add Station in database by station.
     * @param station station  obj.
     *                 @return boolean.
     **/
    public boolean addStation(Station station);

    /**
     * Returns all Station"s from database .
     *                 @return List<Station>.
     **/
    public List<Station> getStationList();

}
