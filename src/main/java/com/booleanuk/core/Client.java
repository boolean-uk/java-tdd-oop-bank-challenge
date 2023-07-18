package com.booleanuk.core;

import java.util.ArrayList;

public class Client {

    String name;
    String lastName;
    String birthDate;
    public Client(String name, String lastName, String birthDate){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
