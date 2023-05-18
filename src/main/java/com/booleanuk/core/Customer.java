package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

enum CUSTOMERCODE {
    NOCODE,
    EXISTS,
    ACCOUNTDOESNTEXISTS

}

public class Customer {

    final private List<CustomerAccount> accounts;
    private CUSTOMERCODE code;

    public Customer() {
        this.accounts = new ArrayList<>();
        code = CUSTOMERCODE.NOCODE;
    }
    public CustomerAccount getCredit(String accountName,String branch) {
        return getAccounts(ACCOUNTTYPE.CREDIT).stream().filter(x -> Objects.equals(x.getAccountName(), accountName) && Objects.equals(x.getBranch(),branch) ).findFirst().orElse(null);
    }
    public CustomerAccount getSavings(String accountName,String branch) {
        return getAccounts(ACCOUNTTYPE.SAVINGS).stream().filter(x -> Objects.equals(x.getAccountName(), accountName) && Objects.equals(x.getBranch(),branch) ).findFirst().orElse(null);

    }
    public boolean createCredit(String accountName,String branch) {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT, accountName,branch);
        if (accountExists(customerAccount)) return false;
        accounts.add(customerAccount);
        return true;
    }
    public boolean createSavings(String accountName,String branch) {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.SAVINGS, accountName,branch);
        if (accountExists(customerAccount)) return false;
        accounts.add(customerAccount);
        return true;
    }
    public String printStatements(CustomerAccount account) {
        String statement = "date || credit  || debit  || balance\n";
        if (!accountExists(account)) return statement;
        return statement + account.printStatements(account);
    }

    public boolean deposit(CustomerAccount account, double amount) {
        return accountExists(account) && account.deposit(amount);
    }

    public boolean withdraw(CustomerAccount account, double amount) {
        return accountExists(account) && account.withdraw(amount);
    }


    public boolean requestOverDraft(CustomerAccount account) {
        account.changeOverdraft();
        return account.isOverdraft();
    }


    private boolean accountExists(CustomerAccount account) {
        for (int i = 0; i < accounts.size(); i++) {
            CustomerAccount customerAccount = accounts.get(i);
            if (Objects.equals(account, customerAccount)) {
                code = CUSTOMERCODE.EXISTS;
                return true;
            }
        }
        code = CUSTOMERCODE.ACCOUNTDOESNTEXISTS;
        return false;
    }

    private List<CustomerAccount> getAccounts(ACCOUNTTYPE type) {
        List<CustomerAccount> theAccounts = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getType() == type) {
                theAccounts.add((accounts.get(i)));
            }
        }
        return theAccounts;
    }


}
