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
       Session session=this.sessionFactory.getCurrentSession();
       User user=(User)session.load(User.class,new Integer(id));


        return user;
    }


    @Override
    public void addUser(User user) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(user);

    }


   public List<User> getUserList() {

        Session session=this.sessionFactory.getCurrentSession();
       List<User> userList= session.createQuery("from User").list();


        return userList;
    }


    @Override
    public User getUserByNameLastName(String first_name, String last_name,Date date_birth) {
       Session session=this.sessionFactory.getCurrentSession();
       Criteria userCriteria=session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("first_name",first_name))
                    .add(Restrictions.eq("last_name",last_name))
              .add(Restrictions.eq("date_birth",date_birth));
        User user=(User)userCriteria.uniqueResult();
        return null;
    }


    @Override
    public int getUserId(User user) {
        Session session=this.sessionFactory.getCurrentSession();
       Criteria userCriteria=session.createCriteria(User.class);
      userCriteria
               .add(Restrictions.eq("first_name",user.getFirst_name()))
              .add(Restrictions.eq("last_name",user.getLast_name()))
              .add(Restrictions.eq("email",user.getEmail()));
        User newUser=(User)userCriteria.uniqueResult();

        return 1;
    }

    @Override
    public void removeUser(int id) {
       Session session=this.sessionFactory.getCurrentSession();
       User user=(User)session.load(User.class,new Integer(id));
        if(user!=null)
       {
           session.delete(user);
       }


    }

    @Override
    public User getUserByName(String username) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(User.class);
        userCriteria
                .add(Restrictions.eq("first_name",username));

        User newUser=(User)userCriteria.uniqueResult();

        return newUser;
    }

}
