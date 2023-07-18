package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void createAccountIfClientExistsTest() {
        Bank bank = new Bank();
        CurrentAccount account = new CurrentAccount(bank);
        Client client = new Client("John", "Smith", "01.01.1998", "234");
        String message = account.createAccount(client);
        Assertions.assertEquals(account.generateAccountNumber(client), message);
    }

    @Test
    public void createAccountIfClientDoesNotExistTest() {
        Bank bank = new Bank();
        CurrentAccount account = new CurrentAccount(bank);
        Client client = new Client("John", "Smith", "01.01.1998", "123");
        String message = account.createAccount(client);
        Assertions.assertEquals("To create account you need to be registered", message);
    }
}
