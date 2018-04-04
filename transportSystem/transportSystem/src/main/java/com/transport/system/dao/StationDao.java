package com.transport.system.dao;

import com.transport.system.model.Station;
import com.transport.system.model.Train;

import java.util.List;

public interface StationDao {


    public Station getStationById(int station_id) ;

    public Station getStationByName(String station_name);

    public boolean addStation(Station station);

    public void updateStation(Station station);

    public List<Station> getStationList();

    public void removeStation(int id);

}
