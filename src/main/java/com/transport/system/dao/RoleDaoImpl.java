package com.transport.system.dao;

import com.transport.system.model.Role;
import com.transport.system.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleById(int role_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Role role=(Role)session.load(Role.class,new Integer(role_id));
        return role;
    }

    @Override
    public Role getRoleByName(String role_name) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(Role.class);
        userCriteria.add(Restrictions.eq("role_name",role_name));
        Role role=(Role)userCriteria.uniqueResult();

        return role;
    }
}

