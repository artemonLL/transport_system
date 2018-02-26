package com.transport.system.controller;


import com.transport.system.model.User;
import com.transport.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserService userService;


    @RequestMapping("/saveuser")
    public String saveuser(Model model)
    {

        return "registration";
    }



    @RequestMapping("/registration")
    public String registration(Model model)
    {

        return "registration";
    }
    @RequestMapping("/singin")
    public String singin(Model model)
    {

        return "singin";
    }


    @RequestMapping("/buyticket")
    public String buyticket(Model model)
    {

        return "buyticket";
    }
}
