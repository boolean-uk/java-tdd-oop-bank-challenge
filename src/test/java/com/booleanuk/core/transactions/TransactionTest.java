package com.booleanuk.core.transactions;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.AccountType;
import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.User;
import com.booleanuk.core.transactons.Transaction;
import com.booleanuk.core.transactons.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TransactionTest {

    @Test
    public void createTransactionReturnsCorrectId() {
        Bank bank = new Bank();
        User customer1 = bank.createUser("P_#2");
        bank.createUserAccount(customer1, AccountType.CURRENT);
        Account account = customer1.getAllAccounts().get(0);

        account.deposit(1000.0);
        account.withdraw(200.00);
        account.withdraw(200.00);

        ArrayList<Transaction> transactions = account.getAllTransactions();

        Assertions.assertEquals("TR_1", transactions.get(0).getId());
        Assertions.assertEquals("TR_2", transactions.get(1).getId());
        Assertions.assertEquals("TR_3", transactions.get(2).getId());
    }

    @Test
    public void getAmountTypeAndCurrentBalance() {
        Bank bank = new Bank();
        User customer1 = bank.createUser("P_#2");
        bank.createUserAccount(customer1, AccountType.CURRENT);
        Account account = customer1.getAllAccounts().get(0);
        account.deposit(10000.00);
        account.withdraw(5000.00);

        ArrayList<Transaction> transactions = account.getAllTransactions();
        Transaction transaction1 = transactions.get(0);
        Transaction transaction2 = transactions.get(1);

        Assertions.assertEquals(10000.00, transaction1.getAmount());
        Assertions.assertEquals(TransactionType.DEBIT, transaction1.getType());
        Assertions.assertEquals(0.00, transaction1.getCurrentBalance());

        Assertions.assertEquals(5000.00, transaction2.getAmount());
        Assertions.assertEquals(TransactionType.CREDIT, transaction2.getType());
        Assertions.assertEquals(10000.00, transaction2.getCurrentBalance());

        Assertions.assertEquals(5000.00, account.getBalance());
    }
}
