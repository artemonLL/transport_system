package com.train.newtask.EJB;

import com.fasterxml.jackson.core.type.TypeReference;
import com.train.newtask.Sender.MessageSender;
import com.train.newtask.WebSocket.WebSocketEndpoint;
import com.train.newtask.entity.SimpleSchedule;

import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;


@Singleton
public class ScheduleEJB {


    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    private MessageSender messageSender;


    private String defStation = "new";

    private List<SimpleSchedule> simpleScheduleList;

    private List<SimpleSchedule> oneStationScheduleList;

    private static List<String> allStations = new ArrayList<>();

    public List<String> getAllStations() {
        return allStations;
    }


    public List<SimpleSchedule> getSimpleScheduleList() {
        return simpleScheduleList;
    }

    public List<SimpleSchedule> getOneStationScheduleList() {
        return oneStationScheduleList;
    }




    public String getDefStation() {
        return defStation;
    }

    public void setDefStation(String defStation) {
        this.defStation = defStation;
    }

 /*   public void setSimpleScheduleList(List<SimpleSchedule> simpleScheduleList) throws JMSException {
        this.simpleScheduleList = simpleScheduleList;
        this.updateAllStations();
        this.updateLstFromStation(defStation);
        logger.info("UPDATE SCHEDULE FROM JMS ****************** " + simpleScheduleList.toString());
    }
    */


    public void updateStationList() throws JMSException {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource("http://localhost:8081/system/scoreboard/stationlist");
        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        List stationlist = (List<String>) response.getEntity(ArrayList.class);
        allStations = stationlist;


        logger.info("*****updateStationList-> GET " + stationlist);


    }

    public void updateListFromDefStation(String stationn) throws JMSException {

        String station = "";
        if (stationn.equals("new")) {
            oneStationScheduleList = new ArrayList<>();
        } else {
            station = stationn;
            defStation = stationn;
            oneStationScheduleList = new ArrayList<>();


            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client.resource("http://localhost:8081/system/scoreboard/stationSchedule/"+stationn);
            ClientResponse response = webResource
                    .accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);

            ObjectMapper mapper = new ObjectMapper();


            List<SimpleSchedule> simpleSchedule = null;
            try {
    simpleSchedule = mapper.readValue(response.getEntityInputStream(), new TypeReference<List<SimpleSchedule>>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }

            oneStationScheduleList= simpleSchedule;
            //  SimpleSchedule simpleSchedule= objectMapper(,SimpleSchedule.class);
            logger.info("ScheduleEJB->getLstFromStation->" + station );

        }
    }




    @PostConstruct
    public void start() throws JMSException {
        updateStationList();
    }
}
