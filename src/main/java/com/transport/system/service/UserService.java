package com.transport.system.service;

import com.transport.system.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface UserService {


    public User getUserById(int id);
    public void addUser(User user);
    public List<User> getUserList();
    public User getUserByNameLastName(String first_name, String last_name,Date date_birth);
    public int getUserId(User user);
    public void removeUser(int id);

}
