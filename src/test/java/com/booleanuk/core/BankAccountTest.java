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
        String expected = "date       || credit  || debit   || balance\n"+ date +" || " + String.format("%.2f",1000.0) + " ||         || ";
        Assertions.assertEquals(expected, account.generateStatements());
    }

    @Test
    void shouldWithdrawMoney(){
        CurrentAccount account = new CurrentAccount();
        account.withdraw(1000.0);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = "date       || credit  || debit   || balance\n"+ date + " ||         || " + String.format("%.2f",1000.0) + " || ";
        Assertions.assertEquals(expected, account.generateStatements());
    }
}
