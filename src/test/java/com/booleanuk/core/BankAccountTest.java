package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

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
        String expected = "date       || credit  || debit   || balance\n"+ date +" || " + String.format(Locale.US,"%.2f",1000.0) + " ||         || "+"1000.00";
        Assertions.assertEquals(expected, account.generateStatements());
    }

    @Test
    void shouldWithdrawMoney(){
        CurrentAccount account = new CurrentAccount();
        account.withdraw(1000.0);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = "date       || credit  || debit   || balance\n"+ date + " ||         || " + String.format(Locale.US,"%.2f",1000.0) + " || "+"-1000.00";
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

    @Test
    void shouldGetNullBranchIfNotSet() {
        CurrentAccount account = new CurrentAccount();
        Assertions.assertNull(account.getBranch());
    }

    @Test
    void shouldSetBranchIfNull() {
        CurrentAccount account = new CurrentAccount();
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Branch branch = new Branch("Athens", "University St. 12", "210-7778100", accounts);
        Assertions.assertTrue(branch.addAccount(account));
        Assertions.assertEquals(1, branch.accounts().size());
        Assertions.assertEquals(branch, account.getBranch());
    }

    @Test
    void shouldReturnFalseIfBranchAlreadyAdded(){
        CurrentAccount account = new CurrentAccount();
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Branch branch = new Branch("Athens", "University St. 12", "210-7778100", accounts);
        Assertions.assertTrue(branch.addAccount(account));
        ArrayList<BankAccount> otherAccounts = new ArrayList<>();
        Branch otherBranch = new Branch("Patra", "Hero St. 45", "2113-778899", otherAccounts);
        Assertions.assertFalse(otherBranch.addAccount(account));
        Assertions.assertEquals(1, branch.accounts().size());
        Assertions.assertEquals(0, otherBranch.accounts().size());
        Assertions.assertEquals(branch, account.getBranch());
    }
}
