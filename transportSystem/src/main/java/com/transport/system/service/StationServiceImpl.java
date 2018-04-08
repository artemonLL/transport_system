package com.transport.system.service;

import com.transport.system.dao.StationDao;
import com.transport.system.messaging.MessageSender;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.transport.system.messaging.MessageSender;
import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.Collections;
import java.util.List;





@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;

    @Autowired
    MessageSender messageSender;

    private static final Logger logr = Logger.getLogger(TrainServiceImpl.class);

    /**
     * Returns Station from database by station's id.
     * @param station_id station's id in the database.
     *                 @return Station obj.
     **/
    @Override
    public Station getStationById(int station_id) {
        return this.stationDao.getStationById(station_id);
    }

    /**
     * Returns Station from database by station's name.
     * @param station_name station's name in the database.
     *                 @return Station obj.
     **/
    @Override
    public Station getStationByName(String station_name) {
        return this.stationDao.getStationByName(station_name);
    }

    /**
     * Add Station in database by station.
     * @param station station  obj.
     *                 @return boolean.
     **/
    @Override
    public boolean addStation(Station station) {
        if(this.stationDao.getStationByName(station.getStation_name())!=null)
        {
            return false;
        }
        logr.info("Station was add "+station);
        this.stationDao.addStation(station);
        return true;
    }


    /**
     * Returns all Station"s from database .
     *                 @return List<Station>.
     **/
    @Override
    public List<Station> getStationList()
    {
        List<Station> stationList= this.stationDao.getStationList();
        Collections.sort(stationList,Station.COMPARE_BY_ID);

        return stationList;
    }




}
