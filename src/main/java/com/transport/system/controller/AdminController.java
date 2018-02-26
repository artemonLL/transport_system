package com.transport.system.controller;

import com.transport.system.model.Train;
import com.transport.system.model.User;
import com.transport.system.service.TrainService;
import com.transport.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;



/*
    @RequestMapping(value = "/admin", method = RequestMethod.GET)

    public ModelAndView showAdminPage(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("admins");

        mav.addObject("train", new Train());

        mav.addObject("trainList",trainService.getTrainList());

        return mav;

    }

    @RequestMapping(value = "/registerTrain", method = RequestMethod.POST)

    public ModelAndView addUser(HttpServletRequest request,
                                HttpServletResponse response,
                                @ModelAttribute("train") Train train) {

        trainService.addTrain(train);

        return new ModelAndView("admin");

    }

*/
        @RequestMapping("/")
        public String home(Model model)
        {
            model.addAttribute("userList",userService.getUserList());

            return "home";
        }

    @RequestMapping("createtrain")
    public ModelAndView createtrain(@ModelAttribute Train train)
    {
        return new ModelAndView("oldadminpage","trainList",trainService.getTrainList());
    }

    @RequestMapping("savetrain")
    public ModelAndView saveTrain(@ModelAttribute Train train)
    {
        trainService.addTrain(train);
        return new ModelAndView("redirect:createtrain");
    }

    @RequestMapping("editTrain")
    public ModelAndView editTrain(@RequestParam int id, @ModelAttribute Train train) {
       train = trainService.getTrainById(id);
        return new ModelAndView("admins", "trainObject", train);
    }





}
