package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {
    private Integer uniqueBankAccountNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;
    private Integer bankID;

    public BankAccount(Integer uniqueBankAccountNumber, ArrayList<Transaction> listOfTransactions, Integer bankID){
        this.uniqueBankAccountNumber = uniqueBankAccountNumber;

        Double totalBalance = 0D;
        for(Transaction transaction : listOfTransactions){
            if(transaction.getTypeOfTransaction().equals("Withdraw")){
                totalBalance -= transaction.getAmount();
            }
            else {
                totalBalance += transaction.getAmount();
            }
        }

        this.balance = Math.round(totalBalance * 100.0) / 100.0;
        this.listOfTransactions = listOfTransactions;
        this.bankID = bankID;
    }

    public BankAccount(Integer uniqueBankAccountNumber, Integer bankID){
        this.uniqueBankAccountNumber = uniqueBankAccountNumber;
        this.balance = 0D;
        this.listOfTransactions = new ArrayList<Transaction>();
        this.bankID = bankID;
    }

    public Double getBalance() {
        Double calculatedBalance = 0D;
        for(Transaction transaction : listOfTransactions){
            if(transaction.getTypeOfTransaction().equals("Withdraw")){
                calculatedBalance -= transaction.getAmount();
            }
            else {
                calculatedBalance += transaction.getAmount();
            }
        }
        return calculatedBalance;
    }

    public Integer getUniqueBankNumber() {
        return uniqueBankAccountNumber;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public Double makeDeposit(Double amount, LocalDateTime dateTime){
        if((this.getBalance() + amount) > this.getBalance()){
            Transaction deposit = new Transaction(dateTime, amount, "Deposit", (this.getBalance() + amount));
            this.listOfTransactions.add(deposit);
            this.balance += amount;
        }
        return this.balance;
    }

    public Double makeWithDraw(Double amount, LocalDateTime dateTime){
        if(amount > 0){
            Transaction withdraw = new Transaction(dateTime, amount, "Withdraw", (this.getBalance() - amount));
            this.listOfTransactions.add(withdraw);
            this.balance -= amount;
        }
        return this.balance;
    }

    public String generateBankStatements(){
        String correctBankStatement = "Date                || Credit   || Debit  || Balance\n";
        System.out.println(this.listOfTransactions.size());
        for(int i = (this.listOfTransactions.size() - 1); i >= 0; i--){
            correctBankStatement += this.listOfTransactions.get(i).formatTransactionForBankStatement() + "\n";
        }
        return correctBankStatement;
    }
}
