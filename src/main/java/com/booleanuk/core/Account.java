package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
   private Branch branch;
    private String accountNumber;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    Account(String accountNumber, Branch branch) {
       this.accountNumber = accountNumber;
       this.branch = new Branch(branch.getBranchId());
    }

}
