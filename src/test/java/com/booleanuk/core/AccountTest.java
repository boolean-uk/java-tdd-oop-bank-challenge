package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Branch center = new Branch();
    Branch west = new Branch();
    Branch east = new Branch();
    Customer customer = new Customer();
    CurrentAccount account1 = new CurrentAccount(customer, center);
    SavingsAccount account2 = new SavingsAccount(customer, center);
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
        account2.deposit(55.6);
        account2.withdraw(5.6);
        account2.printBankStatement();
    }
}
