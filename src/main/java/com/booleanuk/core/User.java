package com.booleanuk.core;

import java.util.Random;

public class User {
    private int id;
    private String name;
    private String branch;

    public User(int id,String name, String branch) {

        this.id = id;
        this.name = name;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }
}
