package com.booleanuk.core;

import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Client;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Branch londonBranch = new Branch(Branches.London, null);
        Client client = new Client("John Doe", "123-456-7890");

        CurrentAccount currentAccount = new CurrentAccount(BigDecimal.valueOf(1000), londonBranch, client);

        SavingsAccount savingsAccount = new SavingsAccount(BigDecimal.valueOf(3000), londonBranch, client);
        sleep();
        Transaction depositTransaction = currentAccount.depositFunds(BigDecimal.valueOf(500));
        sleep();
        Transaction withdrawTransaction = currentAccount.withdrawFunds(BigDecimal.valueOf(200));

        String currentAccountStatement = currentAccount.generateStatement();
        String savingsAccountStatement = savingsAccount.generateStatement();
        System.out.println("Current Account Statement:");
        System.out.println(currentAccountStatement);

        System.out.println("\nSavings Account Statement:");
        System.out.println(savingsAccountStatement);
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
