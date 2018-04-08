package com.transport.system.dao;

import com.transport.system.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {


    public void addUser(User user);
    public User getUserByName(String username);


}
