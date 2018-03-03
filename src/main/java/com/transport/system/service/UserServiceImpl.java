package com.transport.system.service;
import com.transport.system.dao.RoleDao;
import com.transport.system.model.Role;
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

    @Transactional
    @Override
    public User getUserById(int id) {

      return this.userDao.getUserById(id);
    }

    @Override
    public void addUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role_user=roleDao.getRoleById(2);
        user.setRole(role_user);
        userDao.addUser(user);

    }

    @Transactional
    @Override
    public List<User> getUserList() {
        return this.userDao.getUserList();
    }

    @Override
    public User getUserByNameLastName(String first_name, String last_name,Date date_birth) {
        return this.userDao.getUserByNameLastName(first_name,last_name,date_birth);
    }

    @Override
    public int getUserId(User user) {
        return this.userDao.getUserId(user);
    }

    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
