package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void makeABankTest() {
        CurrentAccount currentAccount = new CurrentAccount(500);
        SavingAccount savingAccount = new SavingAccount(50);

        // I want to withdraw from currentAccount and put it in my savingAccount
        currentAccount.withdrawMoney(300);
        savingAccount.depositMoney(300);

        Assertions.assertEquals(200, currentAccount.getBalance());
        Assertions.assertEquals(350, savingAccount.getBalance());
        currentAccount.depositMoney(700);
        currentAccount.depositMoney(1000);
        currentAccount.withdrawMoney(1000);
        currentAccount.withdrawMoney(300);
        currentAccount.printOutTransactions();
    }
}
