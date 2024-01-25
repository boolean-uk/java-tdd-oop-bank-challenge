package com.booleanuk.core;

import java.util.HashMap;
import java.util.Random;

public class Customer {

    int id;
    String firstName;
    String lastName;
    HashMap<Integer,Account> Accounts;

    int accountNumber = 0;

    public Customer(int id, String firstName, String lastName, Account accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Accounts = new HashMap<>();
//        Random random = new Random();
//        int generateAccountNumber = random.nextInt()+100;
        this.Accounts.put(this.accountNumber++,accounts);
    }
    public Customer(){

    }

}
