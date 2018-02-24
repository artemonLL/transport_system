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
    public User getUserByNameLastName(String first_name, String last_name);
    public int getUserId(User user);
    public void removeUser(int id);

}
