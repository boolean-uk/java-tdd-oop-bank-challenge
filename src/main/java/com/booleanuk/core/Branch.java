package com.booleanuk.core;

import java.util.ArrayList;

public class Branch {
    private String name;
    private String location;

    //Constructor
    public Branch(String name, String location){
        setName(name);
        setLocation(location);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
