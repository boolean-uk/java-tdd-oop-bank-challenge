//package com.booleanuk.core;
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//public class TwilioHelper {
//    // Find your Account SID and Auth Token at twilio.com/console
//    // and set the environment variables. See http://twil.io/secure
//    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+14159352345"),
//                        new com.twilio.type.PhoneNumber("+14158141829"),
//                        "Where's Wallace?")
//                .create();
//
//        System.out.println(message.getSid());}
//}
//todo twilio support up to Java 17 not Java 18 !
