package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String branch;
    private List<User> users;

    public Bank(String branch){
        this.branch = setBranch(branch);
        this.users = new ArrayList<>();
    }

    public void createUser(String name, String email, Bank bank){
        User user = new User(name, email, bank);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public Bank setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public String getBranch() {
        return branch;
    }
    public String setBranch(String branch) {
        return this.branch = branch;
    }
}
