package com.train.newtask.EJB;
import com.train.newtask.entity.Train;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class TrainRepository {

    @Inject
    private EntityManager entityManager;

    public Train getById(long id){
        return entityManager.find(Train.class, id);
    }
}
