package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TransactionTest {
    Transaction transaction;

    @BeforeEach
    public void setUp() {
        CurrentAccount currentAccount = new CurrentAccount(BankBranch.PARIS1);
        transaction = new Transaction(currentAccount);
    }

    @Test
    public void shouldDeposit() {
        //Setup
        double amount = 200;

        //Execute
        transaction.deposit(amount);

        //Verify
        Assertions.assertEquals(amount, transaction.getDeposit());
    }

    @Test
    public void shouldNotDeposit() {
        //Setup
        double amount = -100;

        //Execute
        transaction.deposit(amount);

        //Verify
        Assertions.assertEquals(0, transaction.getDeposit());
    }

    @Test
    void shouldGetLocalDateFormatted() {
        //Setup
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        transaction.deposit(100);

        //Execute
        String result = transaction.getLocalDateFormatted();

        //Verify
        Assertions.assertEquals(localDate.format(dateTimeFormatter), result);


    }

    @Test
    void shouldWithdraw() {
        //Setup
        double deposit = 200;
        double withdraw = 100;
        transaction.deposit(200);

        //Execute
        transaction.withdraw(100);

        //Verify
        Assertions.assertEquals(deposit - withdraw, transaction.getBalance());
    }

    @Test
    public void shouldNotWithdraw() {
        //Setup
        double withdraw = 400;
        double deposit = 200;
        transaction.deposit(deposit);

        //Execute
        transaction.withdraw(withdraw);

        //Verify
        Assertions.assertEquals(deposit, transaction.getBalance());
    }
}