package com.train.newtask.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Schedule.class)
public abstract class Schedule_ {

	public static volatile SingularAttribute<Schedule, Integer> way_position;
	public static volatile SingularAttribute<Schedule, Timestamp> time_msk;
	public static volatile SingularAttribute<Schedule, Station> station;
	public static volatile SingularAttribute<Schedule, Integer> schedule_id;
	public static volatile SingularAttribute<Schedule, Train> train;

}

