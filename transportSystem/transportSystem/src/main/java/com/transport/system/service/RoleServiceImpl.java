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


    @Override
    public Role getRoleById(int role_id) {
        return this.roleDao.getRoleById(role_id);
    }


    @Override
    public Role getRoleByName(String role_name) {
        return this.roleDao.getRoleByName(role_name);
    }
}
