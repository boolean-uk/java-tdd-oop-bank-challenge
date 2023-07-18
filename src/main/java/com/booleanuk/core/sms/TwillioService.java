package com.booleanuk.core.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwillioService {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String PHONE_NUMBER = System.getenv("PHONE_NUMBER");

    public void sendSmsMessage(String recipient, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(new PhoneNumber(PHONE_NUMBER),
                        new PhoneNumber(recipient),
                        message)
                .create();

    }
}
