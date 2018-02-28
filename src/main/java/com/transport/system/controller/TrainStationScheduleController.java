package com.transport.system.controller;

import com.transport.system.model.Schedule;
import com.transport.system.model.Station;
import com.transport.system.model.Train;
import com.transport.system.service.ScheduleService;
import com.transport.system.service.StationService;
import com.transport.system.service.TrainService;
import com.transport.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Calendar;


@Controller
public class TrainStationScheduleController {

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;

    @Autowired
    StationService stationService;

    @Autowired
    ScheduleService scheduleService;





    @RequestMapping("schedulelist")
    public ModelAndView schedulelist(@ModelAttribute Schedule schedule)
    {

        ModelAndView mod=new ModelAndView("schedulelist");
        mod.addObject("scheduleList",scheduleService.getScheduleList());

        return mod;
    }
    @RequestMapping("stationlist")
    public ModelAndView stationlist(@ModelAttribute Station station)
    {

        ModelAndView mod=new ModelAndView("stationlist");
        mod.addObject("stationList",stationService.getStationList());

        return mod;
    }


    @RequestMapping("trainlist")
    public ModelAndView trainlist(@ModelAttribute Train train)
    {

        ModelAndView mod=new ModelAndView("trainlist");
        mod.addObject("trainList",trainService.getTrainList());
        return mod;
    }




    @RequestMapping("/")
    public ModelAndView home(@ModelAttribute Schedule schedule)
    {
        ModelAndView mod=new ModelAndView("home");



        Calendar c=Calendar.getInstance();
        c.set(2001 , 2, 7);

        Date newdate2=new Date(c.getTimeInMillis());

        Calendar d=Calendar.getInstance();
        d.set(2004 , 2, 7);

        Date newdate3=new Date(d.getTimeInMillis());


 mod.addObject("selectscheduleList",scheduleService.selectByDatesAndStations(newdate2,newdate3,2,8));

        return mod;
    }





////////// Page to control Train and Station
    @RequestMapping("createallschedule")
    public ModelAndView createallschedule(@ModelAttribute Train train,Station station,Schedule schedule)
    {
        ModelAndView mod=new ModelAndView("oldadminpage");
        mod.addObject("trainList",trainService.getTrainList());
        mod.addObject("stationList",stationService.getStationList());
        mod.addObject("scheduleList",scheduleService.getScheduleList());

        return mod;
    }
///////////ADD SCHEDULE

    @RequestMapping("saveschedule")
    public ModelAndView saveSchedule(@ModelAttribute Schedule schedule ) {
        scheduleService.addSchedule(schedule);

        return new ModelAndView("redirect:createallschedule");
    }

    @RequestMapping("editschedule")
    public ModelAndView editSchedule(@RequestParam int id ,@ModelAttribute Schedule schedule) {
        schedule = scheduleService.getScheduleById(id);
        return new ModelAndView("createallschedule", "scheduleObject",schedule);
    }



///////// ADD TRAIN
    @RequestMapping("savetrain")
    public ModelAndView saveTrain(@ModelAttribute Train train)
    {
        trainService.addTrain(train);
        return new ModelAndView("redirect:createallschedule");
    }

    @RequestMapping("edittrain")
    public ModelAndView editTrain(@RequestParam int id, @ModelAttribute Train train) {
        train = trainService.getTrainById(id);
        return new ModelAndView("createallschedule", "trainObject", train);
    }
//////////ADD STATION

    @RequestMapping("savestation")
    public ModelAndView saveStation(@ModelAttribute Station station)
    {
        stationService.addStation(station);
        return new ModelAndView("redirect:createallschedule");
    }

    @RequestMapping("editstation")
    public ModelAndView editStation(@RequestParam int id, @ModelAttribute Station station) {
        station = stationService.getStationById(id);
        return new ModelAndView("createallschedule", "stationObject", station);
    }




}
