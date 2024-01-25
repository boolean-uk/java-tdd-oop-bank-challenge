package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Customer customer = new Customer();
    CurrentAccount account1 = new CurrentAccount(customer);
    SavingsAccount account2 = new SavingsAccount(customer);
    @Test
    public void depositWithdrawTest() {
        Assertions.assertEquals("New Balance: 88.0", account1.deposit(88));
        Assertions.assertEquals("New Balance: 188.0", account1.deposit(100));
        Assertions.assertEquals("New Balance: 100.0", account1.withdraw(88));
        Assertions.assertEquals("Your balance is low", account1.withdraw(188));
    }
    @Test
    public void bankStatementTest() {
        account1.deposit(88);
        account1.deposit(100);
        account1.printBankStatement();
    }
}
