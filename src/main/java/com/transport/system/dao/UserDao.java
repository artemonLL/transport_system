package com.transport.system.dao;

import com.transport.system.model.Role;
import com.transport.system.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {

    private List<User> userList;

    //date output?

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
        user1.setUser_id("1");
        userList.add(user1);

        User user2=new User();
        user2.setDate_birth(new Date(2020,10,23));
        user2.setEmail("0this_is_email");
        user2.setFirst_name("Some_NAME2");
        user2.setLast_name("Some_Last_name2");
        user2.setPassword("THis_is PAAASSS2");
      //  user2.setRole_id(role);
        user2.setUser_id("2");
        userList.add(user2);

        User user3=new User();
        user3.setDate_birth(new Date(2040,11,22));
        user3.setEmail("0this_is_email3");
        user3.setFirst_name("Some_NAME3");
        user3.setLast_name("Some_Last_name3");
        user3.setPassword("THis_is PAAASSS2");
        //  user2.setRole_id(role);
        user3.setUser_id("3");
        userList.add(user3);

        User user4=new User();
        user4.setDate_birth(new Date(2040,11,22));
        user4.setEmail("0this_is_email3");
        user4.setFirst_name("Some_NAME3");
        user4.setLast_name("Some_Last_name3");
        user4.setPassword("THis_is PAAASSS2");
        //  user2.setRole_id(role);
        user4.setUser_id("4");
        userList.add(user4);

        return userList;
    }

    public User getUserByID(String user_id) throws IOException
    {
        for(User user:getUserList())
        {
            if(user.getUser_id().equals(user_id))
                return user;
        }
        throw new IOException("NO USER FOUND");
    }



}
/*
public class User {


    private String user_id;
    private String first_name;
    private String password;
    private String email;
    private Date date_birth;
    private String last_name;
    private Role role_id;



public class Role {

    private int role_id;
    private String role_name;



*/



