package com.booleanuk.extensions;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    private SmsNotification smsNotification = new SmsNotification();
    private ArrayList<AccountOperation> accountOperations;
    public Account(){
        this.accountOperations = new ArrayList<>();
    }

    public void addDeposit(BigDecimal addBalance){
        if (addBalance.compareTo(BigDecimal.ZERO) >=0) {
            accountOperations.add(new AccountOperation(LocalDateTime.now(), "credit", addBalance));
//            smsNotification.sendNotification("\nBalance updated \nadded: " + addBalance +"PLN, \nBalance: " + getBalance());
        }
        else
            throw new IllegalStateException("You cannot add negative balance");
    }

    public void withdraw(BigDecimal removeFromBalance){
        if (getBalance().subtract(removeFromBalance).compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalStateException("You cannot overdraft, Your max withdraw: " + getBalance());
        else {
            accountOperations.add(new AccountOperation(LocalDateTime.now(), "debit", removeFromBalance));
//            smsNotification.sendNotification("\nBalance updated \nsubtract: " + removeFromBalance +"PLN, \nBalance: " + getBalance());
        }
    }

    public void getBankStatements(){
        accountOperations.sort(Comparator.comparing(AccountOperation::dateOfOperation));
        System.out.printf("%-12s || %-8s || %-7s%n", "date", "credit", "debit");
        System.out.println("-----------------------------------");
        for (AccountOperation account : accountOperations) {
            System.out.println(account.toString());
        }
    }

    public int getAccountOperationsSize(){
        return accountOperations.size();
    }

    public ArrayList<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public BigDecimal getBalance() {
        return accountOperations.stream()
                .map(accountOperation -> {
                    if (accountOperation.typeOfOperation().equals("debit")) {
                        return accountOperation.money().negate();
                    } else if (accountOperation.typeOfOperation().equals("credit")) {
                        return accountOperation.money();
                    } else {
                        throw new IllegalArgumentException("Invalid operation type: " + accountOperation.typeOfOperation());
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
