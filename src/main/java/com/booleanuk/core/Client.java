package com.booleanuk.core;

import java.util.ArrayList;

public class Client {

    String name;
    String lastName;
    String birthDate;

    String id;
    public Client(String name, String lastName, String birthDate, String id){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", id=" + id +
                '}';
    }
}
