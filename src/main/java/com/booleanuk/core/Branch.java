package com.booleanuk.core;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Costumer> costumers = new ArrayList<>();
    String branchId;

    Branch(String branchId) {
        this.branchId = branchId;
    }

}
