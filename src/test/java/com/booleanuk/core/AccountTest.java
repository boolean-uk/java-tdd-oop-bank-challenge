package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void DepositAndWithdrawalTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        // Assert that the transaction history is empty
        Assertions.assertTrue(account.getTransactionHistory().isEmpty());

        int deposit = 1337;
        account.deposit(deposit);

        // Get amount in the first transaction in the log.
        int amount = account.getTransactionHistory().getFirst().amount;

        // Assert that the sum is registered in the transactions.
        Assertions.assertEquals(deposit, amount);

        int withdrawal = 1000;

        account.withdraw(withdrawal);

        int accountBalance = 0;

        // Compute the leftover in the account.
        for (Transaction t : account.getTransactionHistory()){
            accountBalance += t.amount;
        }

        // Assert that the remaining amount is correct
        Assertions.assertEquals(deposit - withdrawal, accountBalance);
    }

}
