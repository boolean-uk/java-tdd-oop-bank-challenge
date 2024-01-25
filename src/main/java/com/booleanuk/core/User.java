package com.booleanuk.core;

public class User {
    private static int users = 1;
    private int userID;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = users;
        users++;
    }

    public int getUserID(){
        return userID;
    }
}
