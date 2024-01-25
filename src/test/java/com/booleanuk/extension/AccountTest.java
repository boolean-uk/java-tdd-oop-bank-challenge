package com.booleanuk.extension;

import com.booleanuk.core.Bank;
import com.booleanuk.core.enums.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Bank bank;

    @BeforeEach
    public void setupTests() {
        this.bank = new Bank();
    }

    @Test
    public void cantWithdrawNonExistentMoney() {
        int accountNumber = bank.createAccount(AccountType.SAVINGS); // Total: 0
        Assertions.assertEquals(0, bank.getAccountBalance(accountNumber));
        bank.performDeposit(accountNumber, 50); // Total: 50
        Assertions.assertEquals(50, bank.getAccountBalance(accountNumber));
        bank.performDeposit(accountNumber, 20.5); // Total: 70.5
        Assertions.assertEquals(70.5, bank.getAccountBalance(accountNumber));
        bank.performWithdrawal(accountNumber, 20); // Total: 50.5
        Assertions.assertEquals(50.5, bank.getAccountBalance(accountNumber));
        bank.performDeposit(accountNumber, 200.5); // Total: 251
        Assertions.assertEquals(251, bank.getAccountBalance(accountNumber));
        bank.performDeposit(accountNumber, 49.0); // Total: 300
        Assertions.assertEquals(300, bank.getAccountBalance(accountNumber));
        bank.performDeposit(accountNumber, 5); // Total: 305
        Assertions.assertEquals(305, bank.getAccountBalance(accountNumber));
        bank.performWithdrawal(accountNumber, 305); // Total: 305
        Assertions.assertEquals(0, bank.getAccountBalance(accountNumber));
    }
}
