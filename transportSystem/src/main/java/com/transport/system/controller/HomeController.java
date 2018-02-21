package com.transport.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {




    @RequestMapping("/")
    public String home(Model model)
    {

        return "home";
    }

    @RequestMapping("/viewSchedule/{user_id}")
    public String viewSchedule(@PathVariable String user_id,Model model) throws IOException
    {
        return "viewSchedule";
    }

}
