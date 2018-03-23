package com.train.newtask.EJB;


import com.train.newtask.entity.Schedule;
import com.train.newtask.entity.SimpleSchedule;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.SerializationUtils;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class UpdateListener implements ExceptionListener {

        public List<SimpleSchedule> start() {
            List<SimpleSchedule> simpleScheduleList=new ArrayList<>();
            try {
                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();
                connection.setExceptionListener(this);
                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue("scheduleUpdate");
                // Create a MessageConsumer from the Session to the Topic or Queue
                MessageConsumer consumer = session.createConsumer(destination);
                // Wait for a message
                Message message = consumer.receive();

                if (message instanceof TextMessage) {
                   TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    
                    String[] splitText=text.split(" ");
                    for(int i=0;i<splitText.length;)
                    {

                            SimpleSchedule simpleSchedule=new SimpleSchedule();
                            simpleSchedule.setTrain(splitText[i]);
                            i++;
                        simpleSchedule.setStation(splitText[i]);
                        i++;
                        long time=Long.parseLong(splitText[i]);
                        Timestamp timestamp=new Timestamp(time);
                        simpleSchedule.setTime(timestamp);
                        i++;
                        simpleScheduleList.add(simpleSchedule);
                    }

                   // TextMessage textMessage = (TextMessage) message;
                  //  String text = textMessage.getText();
                  System.out.println("Received: " + simpleScheduleList);
                } else {
                    System.out.println("Received: " + message);
                }
                consumer.close();
                session.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }



            return simpleScheduleList;
        }
        public synchronized void onException(JMSException ex) {
            System.out.println("JMS Exception occured.  Shutting down client.");
        }
    }

