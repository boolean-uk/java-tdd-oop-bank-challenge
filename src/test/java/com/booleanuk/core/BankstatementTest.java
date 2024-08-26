package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankstatementTest {

    @Test
    public void TestBankstatementSize(){
        AccountOwner me = new AccountOwner("PS1234", "Benjamin Cool");
        CurrentAccount currentAccount = new CurrentAccount(me);
        
        currentAccount.deposit(1000);
        currentAccount.deposit(2000);
        currentAccount.withdraw(500);

        //Should fail due to now being correct size.
        Assertions.assertEquals(3, currentAccount.getBankStatement().size());
    }

    @Test
    public void TestPrintBankstatement(){
        AccountOwner me = new AccountOwner("PS1234", "Benjamin Cool");
        CurrentAccount currentAccount = new CurrentAccount(me);

        currentAccount.deposit(1000);
        currentAccount.deposit(2000);
        currentAccount.withdraw(500);

        currentAccount.printBankstatement();


    }


}
