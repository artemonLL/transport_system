package com.transport.system.controller;


import com.transport.system.model.User;
import com.transport.system.service.SecurityService;
import com.transport.system.service.UserService;
import com.transport.system.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping
public class UserControllers {

    @Autowired
    UserService userService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("userForm",new User());
        return "registration";

    }




    @RequestMapping("saveuser")
    public String saveuser(Model model)
    {

        return "registration";
    }




    @RequestMapping("singin")
    public String singin(Model model)
    {

        return "singin";
    }


    @RequestMapping("buyticket")
    public String buyticket(Model model)
    {

        return "buyticket";
    }
}
