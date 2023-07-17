package com.booleanuk.core;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;

public class TwilioHelper {
    final private String ACCOUNT_SID;
    final private String AUTH_TOKEN;

    public TwilioHelper() {
        Dotenv dotenv = Dotenv.load();
        ACCOUNT_SID = (dotenv.get("TWILIO_ACCOUNT_SID"));
        AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    }

    public boolean sentMessage(String statements) {
        if (this.ACCOUNT_SID==null||this.AUTH_TOKEN==null){
            return false;
        }
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+306947136253"),//To
                        new com.twilio.type.PhoneNumber("+12544254965"),//From
                        statements) //Body
                .create();
        return true;
    }
}

