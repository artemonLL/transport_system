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
        Role role=new Role();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            role = (Role) session.load(Role.class, new Integer(role_id));

    }catch (Exception e)
    {
        e.printStackTrace();
    }

        return role;
    }




    @Override
    public Role getRoleByName(String role_name) {

        Role role=new Role();
        try{
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(Role.class);
        userCriteria.add(Restrictions.eq("role_name",role_name));
        role=(Role)userCriteria.uniqueResult();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return role;
    }


}

