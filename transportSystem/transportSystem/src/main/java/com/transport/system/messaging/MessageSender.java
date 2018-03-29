package com.transport.system.messaging;

import javax.jms.*;

import com.transport.system.model.Schedule;
import com.transport.system.model.SimpleSchedule;
import org.apache.log4j.Logger;
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

    private static final Logger logr = Logger.getLogger(MessageSender.class);

    public void sendMessage(final String message) {

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                String text = message;


                TextMessage message = session.createTextMessage(text);
                logr.warn("SEND MESSAGE ///////////////////////////////////////////"+text);
                return message;
            }
        });
    }

}