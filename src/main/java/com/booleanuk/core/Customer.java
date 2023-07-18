package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Customer {
    private final String name;
    private CurrentAccount current;
    private SavingsAccount savings;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CurrentAccount getCurrent() {
        return current;
    }

    public SavingsAccount getSavings() {
        return savings;
    }

    public void setCurrent(CurrentAccount current) {
        this.current = current;
    }

    public void setSavings(SavingsAccount savings) {
        this.savings = savings;
    }

    public void createCurrent(long number) {
        if(this.current==null)
            this.current = new CurrentAccount(number);
        else System.out.println("Current account already exists");
    }

    public void createSavings(long number) {
        if(this.savings==null)
            this.savings = new SavingsAccount(number);
        else System.out.println("Savings account already exists");
    }

    public BankAccount accountCheck(long number) {
        if(Objects.equals(number, current.getNumber()))
            return current;
        else if(Objects.equals(number, savings.getNumber()))
            return savings;
        else
            System.out.println("Invalid account number");

        return null;
    }

    public void depositFunds(long number, BigDecimal amount) {
        BankAccount account = accountCheck(number);
        if(account==null)
            return;
        account.getTransactionList().add(new Transaction(amount));
        account.setBalance(account.getBalance().add(amount));
    }

    public void withdrawFunds(long number, BigDecimal amount) {
        BankAccount account = accountCheck(number);
        if(account==null)
            return;

        if(!(account.getBalance().compareTo(amount)>=0)) {
            System.out.println("Not enough funds for the withdrawal");
            return;
        }
        account.getTransactionList().add(new Transaction(amount.multiply(BigDecimal.valueOf(-1))));
        account.setBalance(account.getBalance().subtract(amount));
    }

    public String generateBankStatement(long number) {
        StringBuilder sb = new StringBuilder();
        BankAccount account = accountCheck(number);
        if(account==null)
            return "";

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append("date       || credit || debit  || balance\n");
        BigDecimal temp = BigDecimal.ZERO;
        for(Transaction t : account.getTransactionList()) {
            temp=temp.add(t.getAmount());
            if (t.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                sb.append(t.getDate().format(customFormatter) + " || " + t.getAmount() +
                        "  || " + "      " +
                        " || " + temp + "\n");
            }
            else
                sb.append(t.getDate().format(customFormatter) + " || " + "      " +
                        " || " + t.getAmount().multiply(BigDecimal.valueOf(-1)) +
                        "  || " + temp + "\n");
        }
        System.out.println(sb);
        return sb.toString();
    }
}
