package com.transport.system.service;

import com.transport.system.dao.StationDao;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;





@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;


    @Override
    public Station getStationById(int station_id) {
        return this.stationDao.getStationById(station_id);
    }

    @Override
    public Station getStationByName(String station_name) {
        return this.stationDao.getStationByName(station_name);
    }

    @Override
    public void addStation(Station station) {

        this.stationDao.addStation(station);
    }

    @Override
    public void updateStation(Station station) {

        this.updateStation(station);
    }

    @Override
    public List<Station> getStationList() {
        return this.stationDao.getStationList();
    }


}
