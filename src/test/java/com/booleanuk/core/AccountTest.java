package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void newTransactionTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1);
        bank.newCustomer(customer1);
        SavingsAccount savings1 = customer1.getSavingsAccount();
        double newBalance = customer1.newTransaction(savings1, 1000, 0);

        Assertions.assertEquals(customer1.getSavingsAccount().getBalance());




    }
}
