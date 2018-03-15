package com.train.newtask.repository;


import com.train.newtask.entity.Station;
import com.train.newtask.entity.Train;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StationRepository {


    @Inject
    private EntityManager entityManager;

    public Station getById(long id){
        return entityManager.find(Station.class, id);
    }
}
