package com.transport.system.service;

import com.transport.system.dao.RoleDao;
import com.transport.system.model.Role;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.transport.system.dao.UserDao;
import com.transport.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of {@link UserService}.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logr = Logger.getLogger(TrainServiceImpl.class);
    /**
     * Add User to database.
     * @param user user entity.
     *                 @return  void.
     **/
    @Override
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role_user = roleDao.getRoleById(2);
        user.setRole(role_user);
        userDao.addUser(user);
        logr.info("user was add "+user);
    }
    /**
     * Returns User from database by user's name.
     * @param username user's name in the database.
     *                 @return User obj.
     **/
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
