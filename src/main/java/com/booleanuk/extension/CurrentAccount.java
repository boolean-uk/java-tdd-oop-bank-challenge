package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CurrentAccount implements Account {
    private int balance;
    private ArrayList <Transaction> transactions;
    private Branch branch;

    public CurrentAccount(double balance, Branch branch) {

        this.balance = Util.fromDoubleToInt(balance);
        this.transactions=new ArrayList<Transaction>();
        this.branch = branch;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {

        return Util.fromIntToDouble(balance);
    }

    public void setBalance(double balance) {
        this.balance = Util.fromDoubleToInt(balance);
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public void deposit(double amount, LocalDate date) {
        this.setBalance(this.getBalance() + amount);
        this.transactions.add(new Transaction(date, TransactionType.CREDIT,amount, this.getBalance()));
    }

    @Override
    public void withdraw(double amount, LocalDate date) {
        this.setBalance(this.getBalance() - amount);
        this.transactions.add(new Transaction(date, TransactionType.DEBIT,amount, this.getBalance()));
    }

    @Override
    public void generateStatement() {
        List<Transaction> sortedTransactions=this.transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed()).toList();

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("date\t\t||");
        strBuilder.append(" credit\t||");
        strBuilder.append(" debit\t||");
        strBuilder.append(" balance");
        strBuilder.append("\n");

        for (Transaction tr : sortedTransactions) {
            strBuilder.append((tr.getDate()).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))).append("\t||");
            strBuilder.append(" ").append(tr.getType().equals(TransactionType.CREDIT) ? tr.getAmount() : "\t\t").append("\t||");
            strBuilder.append(" ").append(tr.getType().equals(TransactionType.DEBIT) ? tr.getAmount() : "\t\t").append("\t||");
            strBuilder.append(" ").append(tr.getBalance());
            strBuilder.append("\n");
        }
        System.out.println(strBuilder.toString());
    }

}
