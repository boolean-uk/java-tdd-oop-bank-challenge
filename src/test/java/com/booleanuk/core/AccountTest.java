package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    private Account currentAccount;
    private double initialBalance;
    private String branchName;
    private String bankName = "Eurobank";
    private Customer customer;
    @BeforeEach
    public void setup(){
        Bank bank = new Bank(bankName);
        initialBalance = 2500.0;
        branchName = "Eurobank Athens";
        Branch athensBranch = bank.createBranch(branchName);
        String customerId = athensBranch.createCustomer();
        customer = athensBranch.getCustomers().get(customerId);
        String accountId = athensBranch.createAccount(customerId, Bank.AccountType.CURRENT, initialBalance);

        currentAccount = customer.getAccounts().get(accountId);
    }



    @Test
    public void shouldNotDepositIfDepositAmountIsZeroOrNegative(){
        Assertions.assertFalse(currentAccount.deposit(-100.0));
        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());

    }

    @Test
    public void shouldReturnTrueIfDepositAmountIsValid(){
        double depositAmount = 500d;
        double balanceAfterDeposit = initialBalance + depositAmount;
        Assertions.assertTrue(currentAccount.deposit(depositAmount));
        Assertions.assertEquals(BigDecimal.valueOf(balanceAfterDeposit), currentAccount.getBalance());
    }

    @Test
    public void shouldNotWithdrawIfAmountIsGreaterThanBalanceAndIsNotOverdraft(){
        double withdrawAmount = 4000.0;

        Assertions.assertFalse(currentAccount.withdraw(withdrawAmount));
        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());
    }

    @Test
    public void shouldWithdrawIfAmountIsGreaterThanBalanceAndOverdraftAccepted(){
        double withdrawAmount = 4000.0;
        double expectedBalance = initialBalance - withdrawAmount;

        currentAccount.requestOverdraft(withdrawAmount);
        BankManager.evaluateOverdraftRequest(currentAccount.getOverdraftRequest(), Bank.OverdraftStatus.ACCEPTED);

        Assertions.assertEquals(Bank.OverdraftStatus.ACCEPTED, currentAccount.getOverdraftRequest().getStatus());

        currentAccount.withdraw(withdrawAmount);

        Assertions.assertEquals(BigDecimal.valueOf(expectedBalance), currentAccount.getBalance());

    }

    @Test
    public void shouldNotWithdrawIfOverdraftIsRejected(){
        double withdrawAmount = 7000.0;
        currentAccount.requestOverdraft(withdrawAmount);
        BankManager.evaluateOverdraftRequest(currentAccount.getOverdraftRequest(), Bank.OverdraftStatus.REJECTED);
        currentAccount.withdraw(withdrawAmount);

        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());
    }

    @Test
    public void shouldNotWithdrawIfAmountIsGreaterThanRequestedOverdraft(){
        double withdrawAmount = 7000.0;
        currentAccount.requestOverdraft(withdrawAmount);

        BankManager.evaluateOverdraftRequest(currentAccount.getOverdraftRequest(), Bank.OverdraftStatus.ACCEPTED);
        currentAccount.withdraw(7200);

        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());
    }

    @Test
    public void shouldReturnTrueIfWithdrawAmountIsValid(){
        double withdrawAmount = 1000.0;
        double balanceAfterWithdraw = initialBalance - withdrawAmount;

        Assertions.assertTrue(currentAccount.withdraw(withdrawAmount));
        Assertions.assertEquals(BigDecimal.valueOf(balanceAfterWithdraw), currentAccount.getBalance());
    }

    @Test
    public void shouldBeSetToNoneIfOverdraftAmountIsReached(){
        double withdrawAmount = 7000.0;
        currentAccount.requestOverdraft(withdrawAmount);
        BankManager.evaluateOverdraftRequest(currentAccount.getOverdraftRequest(), Bank.OverdraftStatus.ACCEPTED);
        currentAccount.withdraw(withdrawAmount/2);
        currentAccount.withdraw(withdrawAmount/2);

        Assertions.assertEquals(Bank.OverdraftStatus.NONE, currentAccount.getOverdraftRequest().getStatus());
    }

    @Test
    public void shouldNotWithdrawOrDepositMoreTimesThanMonthlyLimitInSavingsAccount(){
        Bank bank = new Bank("BTC Bank");
        Branch athensBranch = bank.createBranch("BTC Bank Athens");

        String customerId = athensBranch.createCustomer();
        Customer customer = athensBranch.getCustomers().get(customerId);
        String accountId = athensBranch.createAccount(customerId, Bank.AccountType.SAVINGS, 100000);
        Account savingsAccount = customer.getAccounts().get(accountId);
        for(int i = 0; i < savingsAccount.getMonthlyTransactionLimit() +1 ; i++){
            if(i < savingsAccount.getMonthlyTransactionLimit() / 2)
                savingsAccount.withdraw(5000);
            else
                savingsAccount.deposit(10000);
        }

        Assertions.assertFalse(savingsAccount.deposit(10000));
        Assertions.assertFalse(savingsAccount.withdraw(800));

    }
}
