package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Person m = new Manager("Nicolai", 31);
        Person c = new Customer("Pia", 25);

        System.out.println(m.getUID());
        System.out.println(c.getUID());
    }
}
