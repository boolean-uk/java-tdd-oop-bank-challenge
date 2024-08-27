package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankstatementTest {

    @Test
    public void TestBankstatementSize(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        CurrentAccount currentAccount = new CurrentAccount(accountOwner, bankManager.getBranch());
        
        currentAccount.deposit(1000);
        currentAccount.deposit(2000);
        currentAccount.withdraw(500);

        //Should fail due to now being correct size.
        Assertions.assertEquals(3, currentAccount.getBankStatement().size());
    }

    @Test
    public void TestPrintBankstatement(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        CurrentAccount currentAccount = new CurrentAccount(accountOwner, bankManager.getBranch());

        currentAccount.deposit(1000);
        currentAccount.deposit(2000);
        currentAccount.withdraw(500);

        currentAccount.printBankstatement();
    }

    @Test
    public void TestPrintEmptyBankstatement(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        CurrentAccount currentAccount = new CurrentAccount(accountOwner, bankManager.getBranch());

        //"No transactions found!"
        currentAccount.printBankstatement();
    }


}
