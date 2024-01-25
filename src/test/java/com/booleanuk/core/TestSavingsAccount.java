package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class TestSavingsAccount {
    @Test
    public void testPrintTransactions(){
        Account account = new SavingsAccount();
        account.deposit(1600);
        account.withdraw(150);
        account.withdraw(300);
        account.withdraw(240);
        account.deposit(1000);
        account.printTransactions();
    }
}
