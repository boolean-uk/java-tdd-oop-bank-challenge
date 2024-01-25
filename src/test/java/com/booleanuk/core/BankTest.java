package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {


    @Test
    void getCurrentName() {
        Account user1 = new Current("232323", "Hassan Hussain", 345.00);
        String result = user1.getName();
        Assertions.assertEquals("Hassan Hussain", result);



    }

    @Test
    void getSavingsName() {
        Account user1 = new Savings("232323", "Hassan Hussain", 345.00);
        String result = user1.getName();
        Assertions.assertEquals("Hassan Hussain", result);


    }




}
