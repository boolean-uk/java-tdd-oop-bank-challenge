package com.booleanuk.extension;

import com.booleanuk.core.AccountType;
import com.booleanuk.core.BankAccount;
import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TwilioTest {

    Customer customer = new Customer("+48721917084",
            "John@gmail.com", "John", "Smith");


    @Test
    public void testTwilioService() throws InterruptedException {
        BankAccount account = customer.createAccount(AccountType.CURRENT, "1234");

        customer.deposit(account.getAccountNumber(), 1000);
        Thread.sleep(1000);

        customer.withdraw(account.getAccountNumber(), 500);
        Thread.sleep(1000);


        customer.deposit(account.getAccountNumber(), 200);
        Thread.sleep(1000);

        customer.deposit(account.getAccountNumber(), 200);
        Thread.sleep(1000);

        System.out.println(customer.getStatements().get(0));

        TwilioService.sendSmsMessage("+48603398103", customer.getStatements().get(0).toString());

        Assertions.assertTrue(true);
    }

}