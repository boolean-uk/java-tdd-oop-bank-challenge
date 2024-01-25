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

    public void createUser(String name, String email){
        User user = new User(name, email, this);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
    public User getUser(int index){
        return users.get(index);
    }

    public void grantUserDraft(User user, double amount){

        return;
    }

    public String getBranch() {
        return branch;
    }
    public String setBranch(String branch) {
        return this.branch = branch;
    }
}
