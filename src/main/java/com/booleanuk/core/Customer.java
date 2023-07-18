package com.booleanuk.core;

import com.booleanuk.core.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private ArrayList<Account> accountsList;

    public Customer() {
        accountsList=new ArrayList<>();
    }

    public void createAccount(String accountType)
    {
        accountsList.add(new Account(accountType));
    }
    public ArrayList<Account> getAccountsList()
    {
        return accountsList;
    }

    public void depositMoney(int account,int amount)
    {
        //Format Date of transaction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTimeNow = LocalDateTime.now().format(formatter);

        accountsList.get(account).addTransaction(formattedDateTimeNow,amount);
    }

    public boolean withdrawMoney(int account,int amount)
    {
        //Format Date of transaction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTimeNow = LocalDateTime.now().format(formatter);

        if(accountsList.get(account).getCurrentBalance()>amount)
        {
            accountsList.get(account).addTransaction(formattedDateTimeNow,-amount);
            return true;
        }
        return false;
    }

}
