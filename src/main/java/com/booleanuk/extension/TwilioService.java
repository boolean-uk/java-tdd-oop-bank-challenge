package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

public class TwilioService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    private static final String PHONE_NUM = dotenv.get("TWILIO_PHONE_NUM");

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static void sendSms(String recipientNumber, String sms) {
        Message.creator(
                new PhoneNumber(recipientNumber),
                new PhoneNumber(PHONE_NUM),
                sms
        ).create();
    }
}
