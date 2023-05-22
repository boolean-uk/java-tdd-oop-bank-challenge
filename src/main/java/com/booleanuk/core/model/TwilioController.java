package com.booleanuk.core.model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
class TwilioController {
        public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
        public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

        public static void sendSms(String context) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+306944444444"),
                            new com.twilio.type.PhoneNumber("+12543584255"),
                            context)
                    .create();

            System.out.println(message.getSid());
        }
}
