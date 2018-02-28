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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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


    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("userList",userService.getUserList());
        model.addAttribute("trainList",stationService.getStationList());

        return "home";
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
