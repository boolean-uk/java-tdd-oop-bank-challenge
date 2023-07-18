package com.booleanuk.core.users;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.SavingsAccount;
import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.accounts.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Customer extends User{
    protected static int customerCount = 0;
    private List<Account> accounts;
    public Customer(String name, String surname, String login, String password, String branchID) {
        super(name, surname, login, password, branchID);

        customerCount += 1;
        String id = "user" + customerCount;
        this.setId(id);
        this.accounts = new ArrayList<>();
    }

    public void createStandardAccount(){
        this.accounts.add(new StandardAccount(this));
    }

    public void createSavingsAccount(Double rate){
        this.accounts.add(new SavingsAccount(this, rate));
    }

    public void deposit(double amount, long accountId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.accounts.stream().filter(a -> a.getId() == accountId)
                .findFirst()
                .get()
                .addTransaction(new Transaction(amount, LocalDateTime.parse("2000-12-12"+ "T00:00:00", formatter)));
    }

    public void withdraw(double amount, long accountId){
        amount = 0.0 - amount;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.accounts.stream().filter(a -> a.getId() == accountId).findFirst().get().addTransaction(new Transaction(amount, LocalDateTime.parse("2000-12-12"+ "T00:00:00", formatter)));
    }

    public String printStatements(){
        String s = "";
        for(Account a: accounts){
            s += "Account: "+ a.getId() +"\n \n";
            s += a.printAccountStatement();
            s += "\n";
        }
        return s;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
