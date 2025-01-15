package com.booleanuk.core;

import java.util.HashMap;

public class CurrentAccount extends Account {
    private String type = "CURRENT";

    public CurrentAccount(int accountNum) {
        super(accountNum);
    }
}
