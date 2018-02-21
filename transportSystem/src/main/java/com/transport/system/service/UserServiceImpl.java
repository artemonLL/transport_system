package com.transport.system.service;

import com.transport.system.dao.UserDao;
import com.transport.system.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService
{
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }



    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUders() {
        return this.userDao.listUsers();
    }
}
