package com.booleanuk.extension;

public class MockSmsService implements SmsService {
    private String phoneNumber;
    private String message;

    @Override
    public void sendSms(String phoneNumber, String message) {
        System.out.println("SMS sent to " + phoneNumber);
        System.out.println("Message:");
        System.out.println(message);

        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
