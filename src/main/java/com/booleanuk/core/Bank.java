package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    public static void main(String[] args){

    }
    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    private List<Account> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
