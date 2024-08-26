package com.booleanuk.core;

import com.booleanuk.core.bank.Account;
import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.CurrentAccount;
import com.booleanuk.core.bank.Customer;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Swedbank");

        Customer max = bank.addCustomer(new Customer());

        Account maxAccount = bank.newAccount(max, new CurrentAccount(Account.Branch.LUND));

        bank.deposit(max, maxAccount, 1000);
        bank.deposit(max, maxAccount, 2000);
        bank.withdraw(max, maxAccount, 500);

        for (String s : max.getTransactionPrintout()) {
            System.out.println(s);
        }
    }

}
