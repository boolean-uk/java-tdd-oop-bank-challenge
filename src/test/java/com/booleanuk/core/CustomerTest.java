package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void getAccountTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        Account savings1 = customer1.getAccount(0);
        bank.newTransaction(savings1,1000,200);
        bank.newTransaction(savings1,1000,200);
        bank.newTransaction(savings1,1000,200);

        Assertions.assertEquals(savings1, customer1.getAccount(0));
    }

}

