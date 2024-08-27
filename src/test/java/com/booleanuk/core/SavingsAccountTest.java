package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    public void TestIfDepositWorks(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        SavingsAccount savingsAccount = new SavingsAccount(accountOwner, bankManager.getBranch());

        //Should give correct return message and increase the arraylist where the transactions are stored by one.
        Assertions.assertEquals("New Balance: 1000.0£", savingsAccount.deposit(1000));
        Assertions.assertEquals(1, savingsAccount.getBankStatement().size());

        Assertions.assertEquals("New Balance: 3000.0£", savingsAccount.deposit(2000));
        Assertions.assertEquals(2, savingsAccount.getBankStatement().size());

    }
    @Test
    public void TestIfTooMuchWithdrawal(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        SavingsAccount savingsAccount = new SavingsAccount(accountOwner, bankManager.getBranch());

        //First it should not work to withdraw anything on a new account with 0.00 balance.
        Assertions.assertEquals("Insufficient Funds", savingsAccount.withdraw(100));

    }

    @Test
    public void TestIfBalanceAndWithdrawalIsSame(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        SavingsAccount savingsAccount = new SavingsAccount(accountOwner, bankManager.getBranch());

        //If I withdraw the same as the balance I have I should get teh message below
        Assertions.assertEquals("New Balance: 0.0£", savingsAccount.withdraw(0));

    }

    @Test
    public void TestIfWithdrawalWorks(){
        BankManager bankManager = new BankManager("David Beckham");

        AccountOwner accountOwner = new AccountOwner("Benjamin Cool");
        SavingsAccount savingsAccount = new SavingsAccount(accountOwner, bankManager.getBranch());

        //If I do a valid withdrawal I should get the correct output and the bankStatement should increment
        //first I deposit 2000£ size of bank statement should now be 1
        savingsAccount.deposit(2000);

        //If i now withdraw 1800£ i expect
        Assertions.assertEquals("New Balance: 200.0£", savingsAccount.withdraw(1800));

        //Should now have two transactions in bank statement.
        Assertions.assertEquals(2, savingsAccount.getBankStatement().size());

    }


}
