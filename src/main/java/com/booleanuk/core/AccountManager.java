package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountManager {


    private  ArrayList<Account> accounts;

    public AccountManager() {
      accounts = new ArrayList<>();
    }

    public Account createAccount(Client client) {
        Account account = new Account(client);
        accounts.add(account);
        return account;
    }

    public SavingAccount createSavingAccount(Client client) {
        SavingAccount savingAccount = new SavingAccount(client);
        accounts.add(savingAccount);
        return savingAccount;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addDeposit(Account account, BigDecimal deposit) {
        account.getStatements().add(new Transaction(deposit));
    }


    public BigDecimal calculateAccountBalance(Account account) {
      return   account.getBalance();
    }
}
