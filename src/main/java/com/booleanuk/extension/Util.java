package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Util {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static double fromIntToDouble(int num) {
        return (double) (num * 100.00);
    }

    public static int fromDoubleToInt(double num) {
        return (int) (num / 100);
    }

    public static void sendSms(String inputMessage) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(System.getenv("MY_PHONE_NUMBER")),
                        new com.twilio.type.PhoneNumber(System.getenv("TWILIO_NUMBER")),
                        inputMessage)
                .create();

        System.out.println(message.getSid());
    }
}
