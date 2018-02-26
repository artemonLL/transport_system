package com.transport.system.dao;

import com.transport.system.model.Station;

public interface StationDao {


    public Station getStationById(int station_id) ;

    public Station getStationByName(String station_name);

}
