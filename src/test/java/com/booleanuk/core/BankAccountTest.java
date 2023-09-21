package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccountTest {
    @Test
    void shouldAddTransactions(){
        SavingsAccount account = new SavingsAccount();
        account.deposit(1000.0);
        Assertions.assertEquals(1, account.transactions.size());
        account.withdraw(1000.0);
        Assertions.assertEquals(2, account.transactions.size());
    }

    @Test
    void shouldDepositMoney(){
        CurrentAccount account = new CurrentAccount();
        account.deposit(1000.0);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = "date       || credit  || debit   || balance\n"+ date +" || " + String.format("%.2f",1000.0) + " ||         || "+"1000,00";
        Assertions.assertEquals(expected, account.generateStatements());
    }

    @Test
    void shouldWithdrawMoney(){
        CurrentAccount account = new CurrentAccount();
        account.withdraw(1000.0);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = "date       || credit  || debit   || balance\n"+ date + " ||         || " + String.format("%.2f",1000.0) + " || "+"-1000,00";
        Assertions.assertEquals(expected, account.generateStatements());
    }

    @Test
    void shouldGetTotalBalance(){
        SavingsAccount account = new SavingsAccount();
        account.withdraw(1000.0);
        Assertions.assertEquals(-1000.0, account.getBalance());
        account.deposit(4000.50);
        account.deposit(2000.50);
        account.withdraw(1001.0);
        Assertions.assertEquals(4000.0, account.getBalance());
    }
}
