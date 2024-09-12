package com.booleanuk.core;
import org.junit.jupiter.api.Test;

public class PhoneMessageTest {
    @Test
    public void testSendMessage() {
        // As a customer,
        //So I can stay up to date,
        //I want statements to be sent as messages to my phone.

        String phoneNumber = "1234567890";
        String message = "Your bank statement for this month is ready!";
        PhoneMessage phoneMessage = new PhoneMessage("1", phoneNumber, message);

        phoneMessage.sendMessage();
    }
}