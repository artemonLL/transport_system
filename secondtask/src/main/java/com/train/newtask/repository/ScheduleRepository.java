package com.train.newtask.repository;


import com.train.newtask.entity.Schedule;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ScheduleRepository
{

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;



    public List<Schedule> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Schedule> criteria = criteriaBuilder.createQuery(Schedule.class);
        Root<Schedule> element = criteria.from(Schedule.class);
        return entityManager.createQuery(criteria).getResultList();
    }

}
