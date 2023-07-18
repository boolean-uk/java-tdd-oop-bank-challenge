package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Account {
    private String accountType;
    private String branch;
    private ArrayList<Transaction> transactions;

    public String getAccountType() {
        return accountType;
    }

    public Account(String accountType,String branch) {
        this.accountType = accountType;
        this.branch = branch;

        transactions = new ArrayList<>();
    }
    public void addTransaction(String date, int amount)
    {
        transactions.add(new Transaction(date,amount));
    }
    public double getCurrentBalance()
    {
        double currentBalance = 0;
        for (Transaction transaction : transactions)
        {
            currentBalance+=(double)transaction.getAmount()/100;
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
                double amountDouble = (double)transaction.getAmount()/100;
                String amountString ="" +String.format("%.2f",amountDouble);
                bankStatement+=insertSpaces(7-amountString.length());
                bankStatement+=amountString+" ";
            }
            else
            {
                //Credit
                bankStatement+=" ||";
                double amountDouble = abs((double)transaction.getAmount()/100);
                String amountString ="" +String.format("%.2f",amountDouble);
                bankStatement+=insertSpaces(7-amountString.length());
                bankStatement+=amountString+" ||";
                //Debit
                bankStatement+="         ";
            }
            //Balance
            double balanceDouble = (double)balance/100;
            String balanceString =""+String.format("%.2f",balanceDouble);;
            bankStatement+="||"+insertSpaces(7-balanceString.length());
            bankStatement+= balanceString+"\n";
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
