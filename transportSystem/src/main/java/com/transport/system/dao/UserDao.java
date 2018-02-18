package com.transport.system.dao;

import com.transport.system.model.Role;
import com.transport.system.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {

    private List<User> userList;


    public List<User> getUserList()
    {
         userList =new ArrayList<User>();

        Role role=new Role();
        role.setRole_id(12);
        role.setRole_name("this_role_name");
        User user1=new User();
        user1.setDate_birth(new Date(2020,10,23));
        user1.setEmail("0this_is_email");
        user1.setFirst_name("Some_NAME");
        user1.setLast_name("Some_Last_name");
        user1.setPassword("THis_is PAAASSS");
     //   user1.setRole_id(role);
        user1.setUser_id(1001);

        userList.add(user1);

        User user2=new User();
        user2.setDate_birth(new Date(2020,10,23));
        user2.setEmail("0this_is_email");
        user2.setFirst_name("Some_NAME2");
        user2.setLast_name("Some_Last_name2");
        user2.setPassword("THis_is PAAASSS2");
      //  user2.setRole_id(role);
        user2.setUser_id(1001);

        userList.add(user2);


        return userList;

    }



}
