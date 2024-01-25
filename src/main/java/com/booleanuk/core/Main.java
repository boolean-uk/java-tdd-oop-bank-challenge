package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Transaction t = new Transaction(100, 100);
        System.out.println(t.getDateTimeString());
    }
}
