package com.train.newtask.repository;
import com.train.newtask.entity.Train;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainRepository {

    @Inject
    private EntityManager entityManager;

    public Train getById(long id){
        return entityManager.find(Train.class, id);
    }
}
