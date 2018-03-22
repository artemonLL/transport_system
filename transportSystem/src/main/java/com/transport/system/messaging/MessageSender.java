package com.transport.system.messaging;

import javax.jms.*;

import com.transport.system.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final List<Schedule> scheduleList) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException{
                TextMessage textMessage = session.createTextMessage("fffffffffff");
                return textMessage ;
            }
        });
    }

}