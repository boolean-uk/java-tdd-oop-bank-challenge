package com.booleanuk.core;

public abstract class Person {
    private String name;
    private int UID;

    public Person(String name, int UID) {
        this.setName(name);
        this.setUID(UID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int ID) {
        this.UID = ID;
    }
}
