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


    /**
     * Add User method add user to database.
     * Method add user to user table.
     * @param user  user entity.
     * @return void.
     * */
    @Override
    public void addUser(User user) {

        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get User By Name  method returns user  from database
     * by name . Method returns user  from user table.
     * @param username user name.
     * @return User entity
     * */
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
