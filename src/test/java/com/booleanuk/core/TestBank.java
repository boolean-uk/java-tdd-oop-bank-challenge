package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBank {

    @Test
    public void TestBankAccountCreated(){

        Customer customer = new Customer("Harry","Potter",1234567);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(createAccount(customer));
    }
}
