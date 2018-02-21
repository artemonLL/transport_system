package com.transport.system.dao;

import com.transport.system.model.User;

import java.util.List;

public interface UserDao
{
    public void addUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();


}
