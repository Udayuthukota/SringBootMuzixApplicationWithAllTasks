package com.stackroute.exceptions;
//TrackNotFoundException class
public class TrackNotFoundException extends Exception {
    private String messsage;

    public TrackNotFoundException(String messsage) {
        super(messsage);
        this.messsage = messsage;
    }
}
