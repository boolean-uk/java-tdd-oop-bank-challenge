package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void TestIfOverdraftRequestIsVisibleForBankManager(){
        //Bank manager created
        BankManager bankManager = new BankManager("David Beckham", 66542);

        //Account owner created
        AccountOwner BenjaminEspresso = new AccountOwner("PS1234", "Benjamin Espresso");

        //Current account created.
        CurrentAccount currentAccount = new CurrentAccount(BenjaminEspresso);
        currentAccount.makeOverdraftRequest(1000, "I need this for my golf clubs");

        //Should now be able to access the crated overdraft request as bank manager.
        Assertions.assertEquals("Mr/Ms Benjamin Espresso requested: 1000.0£ - I need this for my golf clubs", bankManager.getOverdraftRequest(currentAccount));

    }

    @Test
    public void TestIfNoMadeOverdraftRequestShows(){
        //Bank manager created
        BankManager bankManager = new BankManager("David Beckham", 66542);

        //Account owner created
        AccountOwner BenjaminEspresso = new AccountOwner("PS1234", "Benjamin Espresso");

        //Current account created.
        CurrentAccount currentAccount = new CurrentAccount(BenjaminEspresso);
        Assertions.assertEquals("There are no pending overdraft requests for this account.", bankManager.getOverdraftRequest(currentAccount));

    }

    @Test
    public void TestIfManagerCanAcceptOverdraftRequest(){
        //Bank manager created
        BankManager bankManager = new BankManager("David Beckham", 66542);

        //Account owner created
        AccountOwner BenjaminEspresso = new AccountOwner("PS1234", "Benjamin Espresso");

        //Current account created.
        CurrentAccount currentAccount = new CurrentAccount(BenjaminEspresso);
        currentAccount.deposit(500);

        currentAccount.makeOverdraftRequest(900, "I need this for my golf clubs");

        //Should now before being granted the overdraft not be able to withdraw anything above 500;
        Assertions.assertEquals("Insufficient Funds", currentAccount.withdraw(1200));

        //Bank manager now grants the overdraft
        bankManager.grantOverdraft(currentAccount, 900);

        //Should now be able to withdraw the 1200 due to the overdraft being active.
        Assertions.assertEquals("New Balance: -700.0£", currentAccount.withdraw(1200));

        Assertions.assertEquals("Insufficient Funds", currentAccount.withdraw(800));
    }
}
