package com.transport.system.controller;


import com.transport.system.dao.UserDao;
import com.transport.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


    private UserDao userDao=new UserDao();

    @RequestMapping("/")
    public String home(Model model)
    {
        List<User> userList= userDao.getUserList();
        model.addAttribute("users",userList);
        return "home";
    }

    @RequestMapping("/viewSchedule/{user_id}")
    public String viewSchedule(@PathVariable String user_id,Model model) throws IOException
    {
        User user=userDao.getUserByID(user_id);
        model.addAttribute(user);
        return "viewSchedule";
    }


}
