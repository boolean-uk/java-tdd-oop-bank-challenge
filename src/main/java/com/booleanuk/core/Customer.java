package com.booleanuk.core;

import com.booleanuk.core.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer {
    private ArrayList<Account> accountsList;
    HashMap<Account,Integer> overdraftRequests = new HashMap<Account, Integer>();

    public Customer() {
        accountsList=new ArrayList<>();
    }

    public void createAccount(String accountType,String branch)
    {
        accountsList.add(new Account(accountType,branch));
    }
    public ArrayList<Account> getAccountsList()
    {
        return accountsList;
    }

    public void depositMoney(Account account,int amount)
    {
        //Format Date of transaction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTimeNow = LocalDateTime.now().format(formatter);

        account.addTransaction(formattedDateTimeNow,amount);
    }

    public boolean withdrawMoney(Account account,int amount)
    {
        //Format Date of transaction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTimeNow = LocalDateTime.now().format(formatter);

        if(account.getCurrentBalance() >= amount)
        {
            account.addTransaction(formattedDateTimeNow,-amount);
            return true;
        }
        else
        {
            requestOverdraft(account,amount);
            return false;
        }

    }
    public double checkAccountBalance(Account account)
    {
        return account.getCurrentBalance();
    }
    public String generateAccountStatement(Account account)
    {
        return  account.generateBankStatement();
    }
    private void requestOverdraft(Account account, int amount)
    {
            overdraftRequests.put(account,amount);
    }

}
