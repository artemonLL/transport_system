package com.train.newtask.WebSocket;


import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Singleton
@ServerEndpoint("/websocket")
public class WebSocketEndpoint implements Serializable
{

    @Inject
    private Logger logger;

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());


    public void send()
    {
        for(Session session:peers)
        {
            session.getAsyncRemote().sendText("wasaaap");
        }
    }

    @OnOpen
    public void onOpen (Session peer) {
        logger.info("::::::::::::::::::::::::::::::::::::Соединение установленно "+peer.toString());
        peers.add(peer);
    }


    @OnClose
    public void onClose (Session peer) {
        peers.remove(peer);
        logger.info("::::::::::::::::::::::::::::::::::::Соединение Закрыто ");
    }


    @OnMessage
    public String EventMessage(String message){
        System.out.println("Получено сообщение от клиента:"+message);
        String reply="Ваше сообщение: "+message+" было полученно;";
        logger.info("::::::::::::::::::::::::::::::::::::GET "+message);
        return reply;
    }

    @OnError
    public void eventError(Throwable t){
        System.err.println("Error");
    }

}