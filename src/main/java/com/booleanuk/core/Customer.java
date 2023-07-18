package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Customer {
    private final String name;
    private CurrentAccount current;
    private SavingsAccount savings;

    private boolean overCheck = false;

    private BigDecimal overAmount = BigDecimal.ZERO;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isOverCheck() {
        return overCheck;
    }

    public BigDecimal getOverAmount() {
        return overAmount;
    }

    public void setOverCheck(boolean overCheck) {
        this.overCheck = overCheck;
    }

    public void setOverAmount(BigDecimal overAmount) {
        this.overAmount = overAmount;
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
    }

    public void withdrawFunds(long number, BigDecimal amount) {
        BankAccount account = accountCheck(number);
        if(account==null)
            return;

        if(!(account.getBalance().add(overAmount).compareTo(amount)>=0)) {
            System.out.println("Not enough funds for the withdrawal");
            return;
        }

        BigDecimal toSubtract;
        if (account.getBalance().compareTo(BigDecimal.ZERO)>0) {
            toSubtract = amount.subtract(account.getBalance());
        }
        else
            toSubtract = amount;
        account.getTransactionList().add(new Transaction(amount.multiply(BigDecimal.valueOf(-1))));
        if(toSubtract.compareTo(BigDecimal.ZERO)>0)
            this.overAmount = overAmount.subtract(toSubtract);
    }

    public void requestOverdraft(BigDecimal overAmount) {
        if (overCheck) {
            this.overAmount = overAmount;
            return;
        }
        System.out.println("Overdraft request was not accepted yet");
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
