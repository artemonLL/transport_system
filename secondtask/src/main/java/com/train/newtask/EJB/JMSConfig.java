package com.train.newtask.EJB;

import com.train.newtask.Listener.MessageListenerImpl;
import com.train.newtask.WebSocket.WebSocketEndpoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


@Singleton
@Startup
public class JMSConfig {


    private QueueConnection connection;

    private QueueSession session;

    private QueueReceiver receiver;

    @EJB
    ScheduleEJB scheduleEJB;

    @EJB
    WebSocketEndpoint webSocketEndpoint;


    @PostConstruct
    private void startConnection() throws NamingException,JMSException {
        Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put("java.naming.provider.url", "tcp://localhost:61616");
        props.put("queue.js-queue", "scheduleUpdate");
        props.put("connectionFactoryNames", "queueCF");

        Context context = new InitialContext(props);
        QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup("queueCF");
        Queue queue = (Queue) context.lookup("js-queue");

        connection = connectionFactory.createQueueConnection();
        connection.start();
        session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        receiver = session.createReceiver(queue);
        MessageListenerImpl listener = new MessageListenerImpl();
        listener.setScheduleEJB(scheduleEJB);
        listener.setWebSocketEndpoint(webSocketEndpoint);
        receiver.setMessageListener(listener);



    }

    @PreDestroy
    private void closeConnection() {
        try {
            receiver.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            System.out.println("Error");
        }
    }

}
