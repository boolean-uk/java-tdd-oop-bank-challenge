package com.booleanuk.core;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;

public class SmsSender {
    public static Dotenv dotenv = Dotenv.load();
    public static final String ACCOUNT_SID = dotenv.get("TWILIO_ACC");
    public static final String AUTH_TOKEN = dotenv.get("TWILIO_TOKEN");

    public void sendSMS(String body){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(""),
                        new com.twilio.type.PhoneNumber(""),
                        body)
                .create();

    }
}
