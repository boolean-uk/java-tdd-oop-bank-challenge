package com.booleanuk.core;

import java.util.Random;

public class User {
    private int id;
    private String name;
    private String branch;

    public User(String name, String branch) {
        Random random = new Random();
        this.id = random.nextInt(1, 10000);
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
