package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {
    //2. As a customer,
    //So I can save for a rainy day,
    //I want to create a savings account.
    @Test
    public void testSavingsAccountCreation() {
        String accountNumber = "987654321";
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber);

        assertEquals(accountNumber, savingsAccount.getAccountNumber());
        assertEquals(0.0, savingsAccount.getBalance());
    }
}
