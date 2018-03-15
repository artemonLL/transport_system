package com.train.newtask.rest;



import com.train.newtask.entity.Schedule;
import com.train.newtask.repository.ScheduleRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@RequestScoped
@Path("/schedule")
public class ScheduleREST
{

    @Inject
    private Logger logger;

    @Inject
    private ScheduleRepository scheduleRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schedule> getAllUSers(){
        return scheduleRepository.getAll();
    }

}
