package com.transport.system.service;

import com.transport.system.model.Role;
import com.transport.system.model.Schedule;

import java.sql.Date;
import java.util.List;

public interface RoleService {

    /**
     * Returns the Role entity with presented role_id fields.
     * @param role_id the Role ID.
     * @return Role.
     */
    public Role getRoleById(int role_id) ;

    /**
     * Returns the Role entity with presented role_name fields.
     * @param role_name the Role name.
     *                  @return Role.
     */
    public Role getRoleByName(String role_name);



}
