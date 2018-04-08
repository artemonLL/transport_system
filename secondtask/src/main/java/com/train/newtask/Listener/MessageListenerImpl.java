package com.train.newtask.Listener;

import com.train.newtask.EJB.ScheduleEJB;
import com.train.newtask.WebSocket.WebSocketEndpoint;
import com.train.newtask.entity.SimpleSchedule;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Message Listener From ActiveMQ.
 * listens for notifications from the main application when need update application.
 */
public class MessageListenerImpl implements MessageListener {

    private ScheduleEJB scheduleEJB;

    public WebSocketEndpoint getWebSocketEndpoint() {
        return webSocketEndpoint;
    }

    public void setWebSocketEndpoint(WebSocketEndpoint webSocketEndpoint) {
        this.webSocketEndpoint = webSocketEndpoint;
    }

    private WebSocketEndpoint webSocketEndpoint;

    public void setScheduleEJB(ScheduleEJB scheduleEJB) {
        this.scheduleEJB = scheduleEJB;
    }

    public void onMessage(Message message) {

        if(message!=null) {
            List<SimpleSchedule> simpleScheduleList=new ArrayList<>();
            TextMessage textMessage = (TextMessage) message;
            String text = null;
            try {
                text = textMessage.getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }


            if(text.equals(scheduleEJB.getDefStation()))
            {
                try {
                    scheduleEJB.updateListFromDefStation(scheduleEJB.getDefStation());
                   webSocketEndpoint.send();
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
            if(text.equals("stationList"))
            {
                try {
                    scheduleEJB.updateStationList();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            // TextMessage textMessage = (TextMessage) message;
            //  String text = textMessage.getText();

        }

    }

}
