package com.transport.system.service;

import com.transport.system.dao.RoleDao;
import com.transport.system.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    /**
     * Returns the Role entity with presented role_id fields.
     * @param role_id the Role ID.
     * @return Role.
     */
    @Override
    public Role getRoleById(int role_id) {
        return this.roleDao.getRoleById(role_id);
    }

    /**
     * Returns the Role entity with presented role_name fields.
     * @param role_name the Role name.
     *                  @return Role.
     */
    @Override
    public Role getRoleByName(String role_name) {
        return this.roleDao.getRoleByName(role_name);
    }
}
