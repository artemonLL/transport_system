package com.transport.system.exception;

import java.io.Serializable;


/**
 * Exception for not exist Schedule
 *
 */

public class ScheduleNotFoundException extends Exception implements Serializable {
    private String message;
    public ScheduleNotFoundException () {
        this("Schedule was not found");
    }
    private ScheduleNotFoundException(String message) {
        this.message = System.currentTimeMillis() + " : " + message;
    }

    public String getMessage() {
        return message;
    }

}


