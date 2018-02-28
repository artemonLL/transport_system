package com.transport.system.dao;

import com.transport.system.model.Station;
import com.transport.system.model.Train;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TrainDaoImpl implements TrainDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Train getTrainById(int train_id) {
        Session session=this.sessionFactory.getCurrentSession();
        Train train=(Train)session.load(Train.class,new Integer(train_id));
        return train;
    }

    @Override
    public Train getTrainByName(String train_number) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(Train.class);
        userCriteria.add(Restrictions.eq("station_name",train_number));
        Train train=(Train)userCriteria.uniqueResult();

        return train;
    }


    @Override
    public int getTrainIdByName(String train_number) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria userCriteria=session.createCriteria(Train.class);
        userCriteria.add(Restrictions.eq("station_name",train_number));
        Train train=(Train)userCriteria.uniqueResult();

        return train.getTrain_id();
    }

    @Override
    public void addTrain(Train train) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(train);

    }

    @Override
    public void updateTrain(Train train) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(train);

    }

    @Override
    public List<Train> getTrainList() {

        Session session=this.sessionFactory.getCurrentSession();
        List<Train> trainList= session.createQuery("from Train").list();
        return trainList;
    }
}


