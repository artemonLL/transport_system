package com.transport.system.dao;

import com.transport.system.model.Role;

public interface RoleDao
{
    public Role getRoleById(int role_id) ;

    public Role getRoleByName(String role_name);



}
