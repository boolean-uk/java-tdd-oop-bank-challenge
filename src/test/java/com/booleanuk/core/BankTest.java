package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import com.booleanuk.core.exceptions.AccountNotFoundException;
import com.booleanuk.core.models.accounts.Account;
import com.booleanuk.core.models.accounts.CurrentAccount;
import com.booleanuk.core.models.accounts.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    Bank bank;

    @BeforeEach
    public void setupTests() {
        this.bank = new Bank();
    }

    @Test
    public void canCreateNewCurrentAccount() {
        Assertions.assertEquals(0, bank.getAccounts().size());
        bank.createAccount(AccountType.CURRENT);
        Assertions.assertEquals(1, bank.getAccounts().size());
        Assertions.assertInstanceOf(CurrentAccount.class, bank.getAccounts().get(0));
    }

    @Test
    public void canCreateNewSavingsAccount() {
        bank.createAccount(AccountType.SAVINGS);
        Assertions.assertInstanceOf(SavingsAccount.class, bank.getAccounts().get(0));
    }

    @Test
    public void canGetAccountByAccountNumber() {
        int accountNumber = bank.createAccount(AccountType.CURRENT);
        Account account = bank.getAccountByAccountNumber(accountNumber);
        Assertions.assertInstanceOf(CurrentAccount.class, account);
        Assertions.assertEquals(accountNumber, account.getAccountNumber());

        int imaginaryAccountNumber = 1234567;
        Assertions.assertThrows(AccountNotFoundException.class, () -> bank.getAccountByAccountNumber(imaginaryAccountNumber));
    }

    @Test
    public void canDepositMoneyIntoAccount() {
        int accountNumber = bank.createAccount(AccountType.SAVINGS);
        Assertions.assertEquals(5.0, bank.performDeposit(accountNumber, 5));
        Assertions.assertEquals(5.0, bank.getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits());
        Assertions.assertEquals(8.7, bank.performDeposit(accountNumber, 3.7));
    }

    @Test
    public void canWithdrawMoneyFromAccount() {
        int accountNumber = bank.createAccount(AccountType.CURRENT);
        bank.performDeposit(accountNumber, 17.3);
        Assertions.assertEquals(12.3, bank.performWithdrawal(accountNumber, 5));
        Assertions.assertEquals(12.3, bank.getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits());
    }
}
