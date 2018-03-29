package com.train.newtask.EJB;


import com.train.newtask.entity.Station;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Stateless
public class StationRepository {


    @Inject
    private EntityManager entityManager;

    public Station getById(long id){
        return entityManager.find(Station.class, id);
    }
}
