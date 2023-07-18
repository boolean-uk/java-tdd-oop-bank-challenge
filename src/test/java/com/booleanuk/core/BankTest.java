package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankTest {

    private BigDecimal REF_ACCOUNT_BALANCE=BigDecimal.valueOf(1000);

    @Test
    public void shouldCreateCurrentAccount(){
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek", new CustomerAccount(AccountType.CURRENT));
        Assertions.assertDoesNotThrow(() -> bank.accounts.get("Michał Siek"));

    }
    @Test
    public void shouldCreateSavingsAccount(){
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek",new CustomerAccount(AccountType.SAVINGS));
        Assertions.assertDoesNotThrow(() -> bank.accounts.get("Michał Siek"));

    }


    @Test
    public void shouldDepositMoney(){
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek",new CustomerAccount(AccountType.SAVINGS));

        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(200),true);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(500),true);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(100),true);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(200),true);

        Assertions.assertEquals(REF_ACCOUNT_BALANCE, bank.accounts.get("Michał Siek").totalBalance());
    }

    @Test
    public void shouldWithdrawMoney(){
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek",new CustomerAccount(AccountType.CURRENT));

        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(1200),true);
        Assertions.assertEquals(BigDecimal.valueOf(1200), bank.accounts.get("Michał Siek").totalBalance());

        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(200),false);
        Assertions.assertEquals(REF_ACCOUNT_BALANCE, bank.accounts.get("Michał Siek").totalBalance());
    }

    @Test
    public void shouldWithdrawMoneyIntoDebt(){
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek",new CustomerAccount(AccountType.CURRENT));
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(1000),false);
        Assertions.assertEquals(REF_ACCOUNT_BALANCE.multiply(BigDecimal.valueOf(-1)), bank.accounts.get("Michał Siek").totalBalance());
    }
}