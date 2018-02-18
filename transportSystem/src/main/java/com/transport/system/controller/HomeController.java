package com.transport.system.controller;


import com.transport.system.dao.UserDao;
import com.transport.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {


    private UserDao userDao=new UserDao();

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/userList")
    public String getUsers(Model model)
    {
        List<User> userList= userDao.getUserList();
        User user= userList.get(0);
        model.addAttribute(user);
        return "userList";

    }



}
