package com.transport.system.exception;


import java.io.Serializable;

/**
 * Exception for not exist Station
 *
 * @version 1.0\
 */

public class StationNotFoundException extends Exception implements Serializable {
    private String message;

    public StationNotFoundException () {
        this("Station was not found");
    }

    private StationNotFoundException (String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    public String getMessage() {
        return message;
    }
}