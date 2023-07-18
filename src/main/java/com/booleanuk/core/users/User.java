package com.booleanuk.core.users;

public class User {
    protected String id;
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

    protected void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getBranchID() {
        return branchID;
    }
}
