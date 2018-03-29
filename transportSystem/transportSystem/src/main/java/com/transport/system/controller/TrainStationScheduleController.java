package com.transport.system.controller;

import com.transport.system.model.*;
import com.transport.system.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TrainStationScheduleController {


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


    @RequestMapping("schedulelist")
    public ModelAndView schedulelist() {

        ModelAndView mod = new ModelAndView("schedulelist");
        mod.addObject("scheduleList", scheduleService.getScheduleList());

        return mod;
    }

    @RequestMapping("stationlist")
    public ModelAndView stationlist(@ModelAttribute Station station) {

        ModelAndView mod = new ModelAndView("stationlist");
        mod.addObject("stationList", stationService.getStationList());

        return mod;
    }


    @RequestMapping("trainlist")
    public ModelAndView trainlist(@ModelAttribute Train train) {

        ModelAndView mod = new ModelAndView("trainlist");
        mod.addObject("trainList", trainService.getTrainList());
        return mod;
    }


    @RequestMapping("nonono")
    public ModelAndView nonono() {

        ModelAndView mod = new ModelAndView("nonono");
        return mod;
    }
/////////////////////GET USERS FROM TRAIN


    @RequestMapping(value = "/usersfromtrain/{train_id}")
    public ModelAndView usersfromtrain(@PathVariable String train_id) {
        logr.warn(String.format("-----------/usersfromtrain/train_number ----" + train_id));

        Train train = trainService.getTrainById(Integer.parseInt(train_id));

        logr.warn(String.format("-----------/usersfromtrain/train_number(getTrainByName) ----" + train.getTrain_number() + train.getTrain_id()));

        List<User> userList = ticketService.getUserListFromTrain(train);

        logr.warn(String.format("-----------UserList ----" + userList.size()));

        ModelAndView mod = new ModelAndView("usersfromtrain");


        mod.addObject("userList", userList);
        return mod;
    }

    @RequestMapping(value = "/stationschedule/{station_id}")
    public ModelAndView stationschedule(@PathVariable String station_id) {
        Station station = stationService.getStationById(Integer.parseInt(station_id));

        logr.warn("-----------------/stationschedule/get station " + station.getStation_name());
        List<Schedule> scheduleList = scheduleService.getScheduleListByStation(station.getStation_id());

        logr.warn("-----------------/stationschedule/get scheduleList " + scheduleList.size());
        ModelAndView mod = new ModelAndView("stationschedule");


        mod.addObject("scheduleList", scheduleList);
        return mod;
    }


    @RequestMapping(value = "/buyticket", method = RequestMethod.POST)
    public ModelAndView buyticket(@ModelAttribute BuyTicketForm buyticketform) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        String username = "";
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }

        User user1 = userService.getUserByName(username);
        Train train = trainService.getTrainById(buyticketform.getTrain_id());

        int places = train.getPlaces();


        ModelAndView mod = new ModelAndView("nonono");

            List<User> userList = ticketService.getUserListFromTrain(train);
            boolean flag = true;
            for (User user : userList) {
                if (user.getUser_id() == user1.getUser_id()) {
                    flag = false;
                }
            }
            if (flag) {
                //  java.util.Date currentTime=Calendar.getInstance().getTime();
                //  long currTime=currentTime.getTime();

                Ticket ticket = new Ticket();
                ticket.setTrain_id(trainService.getTrainById(buyticketform.getTrain_id()));
                ticket.setArrival_station_id(stationService.getStationById(buyticketform.getArrival_station_id()));
                ticket.setDeparture_station_id(stationService.getStationById(buyticketform.getDeparture_station_id()));
                ticket.setUser_id(user1);
                ticket.setDepartDateTime(buyticketform.getDepartDateTime());
                ticketService.addTicket(ticket);
                train.setPlaces(places-1);
                trainService.updateTrain(train);
                mod = new ModelAndView("redirect:tickets");
            } else {
                mod = new ModelAndView("onlyoneticket");
                mod.addObject("train", train);

            }




            return mod;


        }

    @RequestMapping(value = "/selecttrain", method = RequestMethod.POST)
    public ModelAndView selecttrain(@ModelAttribute Selectform selectform) {

        Selectform newselectform = selectform;


        List<Schedule> scheduleList = scheduleService.selectByDatesAndStations(selectform.getDateOne(), selectform.getDateTwo(), selectform.getStationOne(), selectform.getStationTwo());

        List<Train> trainList = new ArrayList<>();
        if (scheduleList.size() != 0) {
            for (Schedule schedule : scheduleList) {
                trainList.add(schedule.getTrain());
            }
        }
        logr.warn(String.format("-----------//selecttrain/add to model trainList size----" + trainList.size()));

        ModelAndView mod = new ModelAndView("buytickettotrain");

        mod.addObject("newselectform", newselectform);
        mod.addObject("stationList", stationService.getStationList());
        mod.addObject("scheduleList", scheduleList);
        mod.addObject("buyticketform", new BuyTicketForm());

        mod.addObject("trainList", trainList);


        return mod;
    }


    @RequestMapping(value = "/selecttrain", method = RequestMethod.GET)
    public ModelAndView selecttrain() {
        ModelAndView mod = new ModelAndView("selecttrain");

        mod.addObject("stationList", stationService.getStationList());
        mod.addObject("selectform", new Selectform());


        return mod;
    }


    ////////// Page to control Train and Station
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView createallschedule(@ModelAttribute Train train, Station station, Schedule schedule) {


        ModelAndView mod = new ModelAndView("admin");
        mod.addObject("trainList", trainService.getTrainList());
        mod.addObject("stationList", stationService.getStationList());
        mod.addObject("scheduleList", scheduleService.getScheduleList());

        return mod;
    }

    ///////// ADD TRAIN
    @RequestMapping(value = "/savetrain", method = RequestMethod.POST)
    public ModelAndView saveTrain(@ModelAttribute Train train) {

        boolean isAdd = trainService.addTrain(train);

        ModelAndView mod = new ModelAndView();

        if (isAdd == true) {
            mod = new ModelAndView("redirect:admin");
        }
        if (isAdd == false) {
            mod = new ModelAndView("/errortrain");
            mod.addObject("train", train);
        }


        return mod;
    }

    @RequestMapping("/edittrain")
    public ModelAndView editTrain(@RequestParam int id, @ModelAttribute Train train) {
        train = trainService.getTrainById(id);
        return new ModelAndView("admin", "trainObject", train);
    }
///////////ADD SCHEDULE

    @RequestMapping("/saveschedule")
    public ModelAndView saveSchedule(@ModelAttribute Schedule schedule) {


        scheduleService.addSchedule(schedule);

        return new ModelAndView("redirect:admin");
    }

    @RequestMapping("/editschedule")
    public ModelAndView editSchedule(@RequestParam int id, @ModelAttribute Schedule schedule) {
        schedule = scheduleService.getScheduleById(id);
        return new ModelAndView("admin", "scheduleObject", schedule);
    }


//////////ADD STATION

    @RequestMapping(value = "/savestation", method = RequestMethod.POST)
    public ModelAndView saveStation(@ModelAttribute Station station) {

        boolean isAdd = stationService.addStation(station);

        ModelAndView mod = new ModelAndView();

        if (isAdd == true) {
            mod = new ModelAndView("redirect:admin");
        }
        if (isAdd == false) {
            mod = new ModelAndView("/errorstation");
            mod.addObject("station", station);
        }
        return mod;


    }

    @RequestMapping("/editstation")
    public ModelAndView editStation(@RequestParam int id, @ModelAttribute Station station) {
        station = stationService.getStationById(id);
        return new ModelAndView("admin", "stationObject", station);
    }




}
