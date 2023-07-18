package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

public class TwilioService implements SmsService {

    private final String TWILIO_FROM_NUMBER;
    private static volatile TwilioService instance;

    private TwilioService() {

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String TWILIO_ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID", "");
        String TWILIO_AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN", "");
        TWILIO_FROM_NUMBER = dotenv.get("TWILIO_FROM_NUMBER", "");

        try {
            Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
        } catch (AuthenticationException e) {
            System.err.println("Can not authenticate to Twilio");
        }
    }

    public static TwilioService getInstance() {
        if(instance != null)
            return instance;
        synchronized (TwilioService.class) {
            if(instance == null)
                instance = new TwilioService();
            return instance;
        }
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_FROM_NUMBER),
                message
        ).create();
    }
}
