package com.transport.system.service;

import com.transport.system.model.User;

import java.util.List;

public interface UserService
{
    public void addUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUders();


}
