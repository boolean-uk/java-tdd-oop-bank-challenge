package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Account {
    private String accountType;
    private ArrayList<Transaction> transactions;
    private int balance;

    public Account(String accountType) {
        this.accountType = accountType;
        balance = 0;
        transactions = new ArrayList<>();
    }
    public void addTransaction(String date, int amount)
    {
        transactions.add(new Transaction(date,amount));
    }
    public int getCurrentBalance()
    {
        int currentBalance = 0;
        for (Transaction transaction : transactions)
        {
            currentBalance+=transaction.getAmount();
        }
        return  currentBalance;
    }
    public String generateBankStatement()
    {
        String bankStatement ="";
        int balance=0;
        bankStatement+= "date       || credit  || debit  || balance\n";

        for(Transaction transaction : transactions)
        {
            //Date
            bankStatement+=transaction.getDate();
            balance+=transaction.getAmount();
            //Credit and Debit
            if(transaction.getAmount()>0)
            {
                //Credit
                bankStatement+=" ||         ||";
                //Debit
                String amountString ="" +transaction.getAmount();
                bankStatement+=insertSpaces(5-amountString.length());
                bankStatement+=abs(transaction.getAmount())+".00 ";
            }
            else
            {
                //Credit
                bankStatement+=" ||";
                String amountString =""+abs(transaction.getAmount());
                bankStatement+=insertSpaces(5-amountString.length());
                bankStatement+=amountString+".00 ||";
                //Debit
                bankStatement+="         ";
            }
            //Balance
            String balanceString =""+balance;
            bankStatement+="||"+insertSpaces(5-balanceString.length());
            bankStatement+= balance+".00\n";
        }
        return bankStatement;
    }

    private String insertSpaces(int howManySpaces)
    {
        String spaces="";
        for(int i =0;i<howManySpaces;i++)
        {
            spaces+=" ";
        }
        return spaces;
    }
}
