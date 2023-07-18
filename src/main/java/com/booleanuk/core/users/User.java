package com.booleanuk.core.users;

public class User {
    protected long id;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;

    protected String branchID;

    public User(String name, String surname, String login, String password, String branchID) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.branchID = branchID;
    }
}
