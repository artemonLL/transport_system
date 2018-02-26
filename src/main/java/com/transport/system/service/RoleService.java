package com.transport.system.service;

import com.transport.system.model.Role;

public interface RoleService {

    public Role getRoleById(int role_id) ;

    public Role getRoleByName(String role_name);

}
