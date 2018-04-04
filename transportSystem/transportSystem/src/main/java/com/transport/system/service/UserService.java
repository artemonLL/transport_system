package com.transport.system.service;

import com.transport.system.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




/**
 * Service Class for UserBean{@link User}
 */
public interface UserService {

    /**
     * Add User to database.
     * @param user user entity.
     *                 @return  void.
     **/
    public void addUser(User user);

    /**
     * Returns User from database by user's name.
     * @param username user's name in the database.
     *                 @return User obj.
     **/
    public User getUserByName(String username);




}
