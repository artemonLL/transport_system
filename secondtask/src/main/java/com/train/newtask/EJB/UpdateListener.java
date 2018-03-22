package com.train.newtask.EJB;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;


public class UpdateListener implements ExceptionListener {
        public void start() {
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
                Message message = consumer.receive(1000);
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
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
        }
        public synchronized void onException(JMSException ex) {
            System.out.println("JMS Exception occured.  Shutting down client.");
        }
    }

