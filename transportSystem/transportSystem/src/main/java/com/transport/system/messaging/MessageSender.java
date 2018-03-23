package com.transport.system.messaging;

import javax.jms.*;

import com.transport.system.model.Schedule;
import com.transport.system.model.SimpleSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.*;
import java.util.List;


@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final List<Schedule> scheduleList) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException{

                String text="";

                boolean flag=false;
               for(Schedule schedule:scheduleList)
               {
                   if(flag==true)
                   {
                       text=text+" ";
                   }
                   text=text+schedule.getTrain().getTrain_number()+
                           " "+schedule.getStation().getStation_name()+" "+schedule.getTime_msk().getTime();
                   flag=true;
               }


                TextMessage message = session.createTextMessage(text);
                return message ;
            }
        });
    }

}