package com.booleanuk.extensions;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;


public class SmsNotification {
    static Dotenv dotenv = Dotenv.load();
    public static final String ACCOUNT_SID = dotenv.get("ACCOUNT_SID");
    public static final String AUTH_TOKEN = dotenv.get("AUTH_TOKEN");


    public void sendNotification(String notification){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(dotenv.get("PHONE_NUMBER_PERSONAL")),
                        new com.twilio.type.PhoneNumber(dotenv.get("PHONE_NUMBER_TWILO")),
                        notification)
                .create();
    }

    public static void main(String[] args) {
        System.out.println(ACCOUNT_SID);
    }
}