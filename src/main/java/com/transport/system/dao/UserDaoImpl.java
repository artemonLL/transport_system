package com.transport.system.dao;

import com.transport.system.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User getUserById(int id) {

        User user = new User();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            user = (User) session.load(User.class, new Integer(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


    @Override
    public void addUser(User user) {

        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public List<User> getUserList() {

        List<User> userList = new ArrayList<>();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            userList = session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return userList;
    }


    @Override
    public User getUserByNameLastName(String username, String last_name, Date date_birth) {
        User user;
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("username", username))
                    .add(Restrictions.eq("last_name", last_name))
                    .add(Restrictions.eq("date_birth", date_birth));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void removeUser(int id) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            User user = (User) session.load(User.class, new Integer(id));
            if (user != null) {
                session.delete(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getUserByName(String username) {

        User newUser = new User();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria
                    .add(Restrictions.eq("username", username));

            newUser = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return newUser;
    }

}
