package com.transport.system.service;

import com.transport.system.dao.StationDao;
import com.transport.system.messaging.MessageSender;
import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
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
    ScheduleService scheduleService;

    @Autowired
    MessageSender messageSender;


    @Override
    public Station getStationById(int station_id) {
        return this.stationDao.getStationById(station_id);
    }

    @Override
    public Station getStationByName(String station_name) {
        return this.stationDao.getStationByName(station_name);
    }

    @Override
    public boolean addStation(Station station) {


        if(this.stationDao.getStationByName(station.getStation_name())!=null)
        {
            return false;
        }

        this.stationDao.addStation(station);
        return true;
    }

    @Override
    public void updateStation(Station station) {

        this.updateStation(station);
    }

    @Override
    public List<Station> getStationList()
    {
        List<Station> stationList= this.stationDao.getStationList();
        Collections.sort(stationList,Station.COMPARE_BY_ID);

        return stationList;
    }

    @Override
    public boolean removeStation(int id) {
        Station station= stationDao.getStationById(id);
        if(station!=null)
        {
            stationDao.removeStation(id);
            return true;
        }
        return false;
    }


}
