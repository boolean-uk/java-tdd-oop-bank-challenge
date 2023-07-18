package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankBranchTest {
    BankBranch bank;

    @BeforeEach
    public void setUp() {
        bank = new BankBranch();
    }

    @Test
    public void whenCreateAccountIsCurrentAccountCalled_createsCurrentAccount(){
        //When
        int accountNumber = bank.createAccount(true);
        //Then
        Assertions.assertInstanceOf(CurrentAccount.class, bank.getAccount(accountNumber));
    }

    @Test
    public void whenCreateAccountNotIsCurrentAccountCalled_createsSavingsAccount(){
        //When
        int accountNumber = bank.createAccount(false);
        //Then
        Assertions.assertInstanceOf(SavingsAccount.class, bank.getAccount(accountNumber));
    }



}
