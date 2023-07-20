package com.booleanuk.core;

public class PhoneMessage {
    private String messageId;
    private String phoneNumber;
    private String message;

    public PhoneMessage(String messageId, String phoneNumber, String message) {
        this.messageId = messageId;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public void sendMessage() {
        System.out.println("Message sent to " + phoneNumber + ": " + message);
    }
}
