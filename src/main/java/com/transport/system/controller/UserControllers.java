package com.transport.system.controller;


import com.transport.system.model.Selectform;
import com.transport.system.model.User;
import com.transport.system.service.SecurityService;
import com.transport.system.service.UserService;
import com.transport.system.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class UserControllers {

    @Autowired
    private UserService userService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }



    @RequestMapping(value = {"/", "/home"},method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute Selectform selectform)
    {
        ModelAndView mod=new ModelAndView("home");

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


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model,String error,String logout)
    {
        if(error!=null)
        {
            model.addAttribute("error","Username or Password is incorrect.");
        }

        if(logout!=null)
        {
            model.addAttribute("massage","Logget out successfully.");
        }

        return "login"; }


        @RequestMapping(value = "/admin")
        public String admin(Model model)
        {
            return "admin";
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
