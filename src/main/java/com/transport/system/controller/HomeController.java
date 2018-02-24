package com.transport.system.controller;


import com.transport.system.dao.UserDao;
import com.transport.system.model.User;
import com.transport.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;


    @RequestMapping("/")
    public String home(Model model)
    {

        List<User> users=userService.getUserList();


        model.addAttribute("user",users);
        return "home";
    }

    @RequestMapping("/viewSchedule/{user_id}")
    public String viewSchedule(@PathVariable String user_id,Model model) throws IOException
    {/*
        User user=userDao.getUserByID(user_id);
        model.addAttribute(user);*/
        return "viewSchedule";
    }
    @RequestMapping("/clients/")
    public String clients(Model model) throws IOException
    {
        return "clients";
    }



}
