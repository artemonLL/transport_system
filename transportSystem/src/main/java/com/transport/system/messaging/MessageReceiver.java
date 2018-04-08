package com.transport.system.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.transport.system.model.Schedule;
import com.transport.system.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Component
public class MessageReceiver implements MessageListener{

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    MessageConverter messageConverter;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    MessageSender messageSender;

    /**
     * Message Receiver from ActiveMQ  dont use now.
     * @param message message.
     * */
    @Override
    public void onMessage(Message message) {
        if(message!=null) {

            TextMessage textMessage = (TextMessage) message;
            String text = null;
            try {
                text = textMessage.getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            if(text.equals("GiveLittleSchedulePlease"))
            {
                List<Schedule> scheduleList=scheduleService.getScheduleList();
                messageSender.sendMessage("stationList");
            }

            // TextMessage textMessage = (TextMessage) message;
            //  String text = textMessage.getText();
        }
        else
        {
            System.out.println("Received: " +" NULL MASSAGe");
        }
    }
}