package com.transport.system.service;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;

import java.sql.Date;
import java.util.List;

public interface StationService {

    public Station getStationById(int station_id) ;

    public Station getStationByName(String station_name);

    public void addStation(Station station);

    public void updateStation(Station station);

    public List<Station> getStationList();



}
