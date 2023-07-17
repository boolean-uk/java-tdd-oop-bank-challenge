package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TestAccount {

    @Test
    public void testDeposit(){
        Account newAccount = new Account("Test Branch");
        newAccount.depositAccount(200.0);
        List<Double>  Balance = new ArrayList<>();
        List<Double>  Credits = new ArrayList<>();
        Balance.add(200.0);
        Credits.add(200.0);


        Assertions.assertEquals(Balance.get(0), newAccount.balance(Credits.size()) );
        Assertions.assertEquals(Credits, newAccount.getCredits() );

        newAccount.depositAccount(500.0);
        Balance.add(700.0);
        Credits.add(500.0);


        Assertions.assertEquals(Balance.get(1), newAccount.balance(2) );
        Assertions.assertEquals(Credits, newAccount.getCredits() );
        Assertions.assertEquals(2, newAccount.getTransactionDates().size());


    }

    @Test
    public void TestWithdraw(){
        Account newAccount = new Account("Test Branch");
        newAccount.depositAccount(200.0);
        List<Double>  Balance = new ArrayList<>();
        List<Double>  Credits = new ArrayList<>();
        List<Double>  Debits = new ArrayList<>();
        Balance.add(200.0);
        Credits.add(200.0);


        Assertions.assertEquals(Balance.get(0), newAccount.balance(Credits.size()));
        Assertions.assertEquals(Credits, newAccount.getCredits() );

        newAccount.depositAccount(500.0);
        Balance.add(700.0);
        Credits.add(500.0);

        Assertions.assertEquals("Thank you for using our services",newAccount.withdrawAccount(300.0));
        Balance.add(400.0);
        Debits.add(0.0);
        Debits.add(0.0);
        Debits.add(300.0);
        Credits.add(0.0);
        Balance.add(700.0);

        Assertions.assertEquals("You don´t have enough money in your account, sorry", newAccount.withdrawAccount(500));

        Assertions.assertEquals(Balance.get(3), newAccount.balance(2));
        Assertions.assertEquals(Credits, newAccount.getCredits() );
        Assertions.assertEquals(Debits, newAccount.getDebits());
        Assertions.assertEquals(3, newAccount.getTransactionDates().size());

    }

    @Test
    public void TestPrint(){
        Account newAccount = new Account("Test Branch");
        newAccount.depositAccount(200.0);
        List<Double>  Balance = new ArrayList<>();
        List<Double>  Credits = new ArrayList<>();
        List<Double>  Debits = new ArrayList<>();
        Balance.add(200.0);
        Credits.add(200.0);
        Assertions.assertEquals(Balance.get(0), newAccount.balance(Credits.size()) );
        newAccount.depositAccount(500.0);
        newAccount.withdrawAccount(300);
        System.out.println(newAccount.PrintAccount());


}

}
