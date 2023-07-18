package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    private BigDecimal balance;
    private ArrayList<AccountOperation> accountOperations;

    public Account(){
        this.balance = BigDecimal.ZERO;
        this.accountOperations = new ArrayList<>();
    }

    public void addDeposit(BigDecimal addBalance){
        if (addBalance.compareTo(BigDecimal.ZERO) >=0) {
            balance = balance.add(addBalance);
            accountOperations.add(new AccountOperation(LocalDateTime.now(), this.balance, "credit", addBalance));
        }
        else
            throw new IllegalStateException("You cannot add negative balance");
    }

    public void withdraw(BigDecimal removeFromBalance){
        if (balance.subtract(removeFromBalance).compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalStateException("You cannot overdraft, Your max withdraw: " + balance);
        else {
            balance = balance.subtract(removeFromBalance);
            accountOperations.add(new AccountOperation(LocalDateTime.now(), this.balance, "debit", removeFromBalance));
        }
    }

    public void getBankStatements(){
        accountOperations.sort(Comparator.comparing(AccountOperation::dateOfOperation));
        System.out.printf("%-12s || %-8s || %-7s || %-8s%n", "date", "credit", "debit", "balance");
        System.out.println("-----------------------------------------------------");
        for (AccountOperation account : accountOperations) {
            System.out.println(account.toString());
        }
    }

    public int getAccountOperationsSize(){
        return accountOperations.size();
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
