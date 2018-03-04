package com.transport.system.service;

import com.transport.system.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




/**
 * Service Class for UserBean{@link User}
 */
public interface UserService {


    public User getUserById(int id);
    public void addUser(User user);
    public List<User> getUserList();
    public User getUserByNameLastName(String username, String last_name,Date date_birth);
    public int getUserId(User user);
    public void removeUser(int id);
    public User getUserByName(String username);




}
