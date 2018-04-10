package com.train.newtask.EJB;
import com.fasterxml.jackson.core.type.TypeReference;
import com.train.newtask.Sender.MessageSender;
import com.train.newtask.entity.SimpleSchedule;
import java.io.IOException;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main class with methods to get station list and
 * get schedule list when the station is selected.
 **/
@Singleton
public class ScheduleEJB {
    @Inject
    private Logger logger;
    @Inject
    private EntityManager entityManager;

    private MessageSender messageSender;

    /**
     * Default name station to get updates from main app.
     **/
    private String defStation = "new";
    /**
     * Schedule List of default station what updates from main app.
     **/
    private List<SimpleSchedule> oneStationScheduleList;

    private static List<String> allStations = new ArrayList<>();

    public List<String> getAllStations() {
        return allStations;
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
    /**
     * Update allStations(Station List) from REST service in main application.
     * Get List<Sting> stationList.
     **/
    public void updateStationList() throws JMSException {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource("http://localhost:8081/scoreboard/stationlist");
        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        List stationlist = (List<String>) response.getEntity(ArrayList.class);
        allStations = stationlist;
        Collections.sort(allStations);
        logger.info("*****updateStationList-> GET " + stationlist);
    }
    /**
     * Update Schedule from REST service in main application.
     * @param  stationn station which Schedule List will get from REST service.
     *                 @return Schedule obj.
     **/
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
            WebResource webResource = client.resource("http://localhost:8081/scoreboard/stationSchedule/"+stationn);
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

            oneStationScheduleList= getCurrendDay(simpleSchedule);

            Collections.sort(oneStationScheduleList,SimpleSchedule.COMPARE_BY_TIME);
            //  SimpleSchedule simpleSchedule= objectMapper(,SimpleSchedule.class);
            logger.info("ScheduleEJB->getLstFromStation->" + station );
        }
    }
    @PostConstruct
    public void start() throws JMSException {
        updateStationList();
    }
    public List<SimpleSchedule> getCurrendDay(List<SimpleSchedule> list)
    {
        List<SimpleSchedule> outList=new ArrayList<>();
        Date newDate=new Date();
        for(SimpleSchedule simpleSchedule:list)
        {
           if(byToday(simpleSchedule)==true)

           {
               outList.add(simpleSchedule);
           }
        }
        return outList;
    }
    private boolean byToday(SimpleSchedule schedule) {
        Date date=new Date(schedule.getTime().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(schedule.getTime());
        LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        LocalDate departure =localDate;
        LocalDate now = LocalDate.now();


        return departure.isEqual(now);
}
}
