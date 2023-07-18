package com.booleanuk.core;

public class CurrentAccount extends Account {
    String type = "current";

    public CurrentAccount(String firstname, String lastname) {
        super(firstname, lastname);
    }
}
