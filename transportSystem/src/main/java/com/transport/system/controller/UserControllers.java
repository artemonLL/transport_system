package com.transport.system.controller;


import com.transport.system.dao.UserDao;
import com.transport.system.model.*;
import com.transport.system.service.*;
import com.transport.system.validator.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
/**
 * The User controller, which allows user to view pages.
 */
@Controller
@RequestMapping
public class UserControllers {

    private static final Logger logr = Logger.getLogger(TrainStationScheduleController.class);

    @Autowired
    private UserService userService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }


    @RequestMapping(value = "/tickets")
    public ModelAndView tickets(@ModelAttribute Ticket ticket) {

        logr.info(String.format("-----------/tickets/ USER GET---------------Yes"));
        ModelAndView mod = new ModelAndView("tickets");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //GET USER FROM SECURITY
        Object obj = auth.getPrincipal();
        String username = "";
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }
        User user1 = userService.getUserByName(username);
        logr.info(String.format("-----------/tickets/ USER GET---------------Yes"));

        List<Ticket> ticketList = ticketService.getTicketListsByUser(user1);

        logr.info(String.format("-----------/tickets/ GET USER TICKETS---------------Yes" + ticketList.size()));

        mod.addObject("ticketList", ticketList);

        return mod;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/home";
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute Selectform selectform) {


        ModelAndView mod = new ModelAndView("home");


        mod.addObject("stationList", stationService.getStationList());
        mod.addObject("selectform", new Selectform());
        return mod;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or Password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("massage", "Logget out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/buybuybuy/{train_number}")
    public ModelAndView buybuybuy(@PathVariable String train_number) {


        logr.info(String.format("-----------train number " + train_number));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        String username = "";
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }

        User user1 = userService.getUserByName(username);


        logr.info(String.format("-----------User " + user1.getUsername()));


        Train train = trainService.getTrainByName(train_number);


        logr.info(String.format("-----------train train " + train.getTrain_number()));

        if (trainService.getFreePlaces(train.getTrain_id()) != 0) {
        }
        Ticket ticket = new Ticket();
        ModelAndView mod = new ModelAndView("redirect:tickets");

        return mod;
    }


    @RequestMapping("saveuser")
    public String saveuser(Model model) {

        return "registration";
    }


}
