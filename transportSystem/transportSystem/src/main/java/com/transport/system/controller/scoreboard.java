package com.transport.system.controller;


import com.transport.system.model.Schedule;
import com.transport.system.model.SimpleSchedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * RESTful controller. Provides web services of application.
 */
@RestController
@RequestMapping(value = "/scoreboard")
public class scoreboard {

    private static final Logger logr = Logger.getLogger(TrainStationScheduleController.class);

    @Autowired
    private TrainService trainService;

    @Autowired
    private UserService userService;

    @Autowired
    private StationService stationService;

    @Autowired
    private ScheduleService scheduleService;


    @Autowired
    private TicketService ticketService;



    @RequestMapping(value = "stationlist", method = RequestMethod.GET)
    public ResponseEntity<List<String>> trainList() {

        List<String> stringStationList=new ArrayList<>();
        List<Station> stations=stationService.getStationList();
        for(Station station:stations)
        {
            stringStationList.add(station.getStation_name());
        }

        return new ResponseEntity<List<String>>(stringStationList, HttpStatus.OK);
    }

    @RequestMapping(value = "stationSchedule/{station}", method = RequestMethod.GET)
public ResponseEntity<List<SimpleSchedule>> stationSchedule(@PathVariable("station") String station) {
        List<SimpleSchedule> simpleScheduleList=new ArrayList<>();
  List<Schedule>scheduleList=scheduleService.getScheduleListByStation(stationService.getStationByName(station).getStation_id());
  for (Schedule schedule:scheduleList)
  {
      SimpleSchedule simpleSchedule =new SimpleSchedule();
      simpleSchedule.setTrain(schedule.getTrain().getTrain_number());
      simpleSchedule.setStation(schedule.getStation().getStation_name());
      simpleSchedule.setPlatform(schedule.getWay_position());
      simpleSchedule.setTime(schedule.getTime_msk());
      simpleScheduleList.add(simpleSchedule);
  }
        return new ResponseEntity<List<SimpleSchedule>>(simpleScheduleList, HttpStatus.OK);
    }



}
