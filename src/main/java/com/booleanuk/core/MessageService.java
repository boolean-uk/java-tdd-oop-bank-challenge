package com.booleanuk.core;

public class MessageService {

    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
