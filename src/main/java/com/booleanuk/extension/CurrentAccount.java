package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentAccount implements Account {
    private int balance;
    private ArrayList <Transaction> transactions;
    private Branch branch;
    private boolean overdraft;
    public CurrentAccount(double balance, Branch branch) {

        this.balance = Util.fromDoubleToInt(balance);
        this.transactions=new ArrayList<Transaction>();
        this.branch = branch;
        this.overdraft= false;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        int result = 0;
        for (Transaction tr : this.transactions) {
            if (tr.getType().equals(TransactionType.CREDIT)){
                result+=Util.fromDoubleToInt(tr.getAmount());
            } else if (tr.getType().equals(TransactionType.DEBIT)){
                result-=Util.fromDoubleToInt(tr.getAmount());
            }
        }

        return Util.fromIntToDouble(result);
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

    public boolean isOverdraft() {
        return overdraft;
    }

    public void setOverdraft(boolean overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void deposit(double amount, LocalDate date) {
        this.transactions.add(new Transaction(date, TransactionType.CREDIT,amount, this.getBalance()+ amount));
    }

    @Override
    public String withdraw(double amount, LocalDate date) {
        if ((this.getBalance()-amount) >= 0){
            this.transactions.add(new Transaction(date, TransactionType.DEBIT,amount, this.getBalance()- amount));
            return "Transaction succeeded";
        } else if ((this.getBalance()-amount) < 0 && this.isOverdraft()) {
            this.transactions.add(new Transaction(date, TransactionType.DEBIT,amount, this.getBalance()- amount));
            return "Transaction succeeded";
        }
        return "Overdraft not allowed";
    }

    @Override
    public String generateStatement() {
//        List<Transaction> sortedTransactions=this.transactions.stream()
//                .sorted(Comparator.comparing(Transaction::getDate).reversed()).toList();
        List<Transaction> sortedTransactions=this.transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed()).collect(Collectors.toList());

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
        return strBuilder.toString();
    }

}
