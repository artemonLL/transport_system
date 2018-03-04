package com.transport.system.dao;

import com.transport.system.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {


    public User getUserById(int id);
    public void addUser(User user);
    public List<User> getUserList();
    public User getUserByNameLastName(String username, String last_name,Date date_birth);
    public int getUserId(User user);
    public void removeUser(int id);
    public User getUserByName(String username);


}
