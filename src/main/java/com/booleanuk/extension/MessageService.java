package com.booleanuk.extension;

import com.twilio.rest.api.v2010.account.Message;

import static java.lang.System.getenv;

public class MessageService {
    public static final String ACCOUNT_SID = getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = getenv("TWILIO_AUTH_TOKEN");
    public static final String FROM_PHONE_NUMBER = getenv("TWILIO_PHONE_NUMBER");

    public static String send(String messageText, Customer customer) {
        com.twilio.Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(customer.getPhoneNumber()),
                        new com.twilio.type.PhoneNumber(FROM_PHONE_NUMBER),
                        messageText)
                .create();
        return message.getStatus().toString();
    }
}
