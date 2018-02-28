package com.transport.system.service;

import com.transport.system.model.Role;
import com.transport.system.model.Schedule;

import java.sql.Date;
import java.util.List;

public interface RoleService {

    public Role getRoleById(int role_id) ;

    public Role getRoleByName(String role_name);



}
