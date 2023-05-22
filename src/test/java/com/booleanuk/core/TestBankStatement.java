package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class TestBankStatement {

    @Test
    public void TestDate() {
        BankStatement bs = new BankStatement();
        Date LocalDate = new Date(2023, 05, 19);

        Assertions.assertEquals("2023-05-19", bs.getDate().toString() );

    }

    @Test
    public void TestDeposit(){
        BankStatement bs = new BankStatement();
        bs.deposit(600);

        Assertions.assertEquals(600, bs.getBalance());

        bs.deposit(700);
        Assertions.assertEquals(1300, bs.getBalance());
    }

    @Test
    public void TestWithdraw(){
        BankStatement bs = new BankStatement();
        bs.deposit(600);
        bs.withdraw(200);
        bs.withdraw(100);
        Assertions.assertEquals(300, bs.getBalance());

    }



}


