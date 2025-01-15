package com.booleanuk.core;

import java.util.Random;

public class IdGenerator {

    private Random rand;
    private String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public IdGenerator() {
        this.rand = new Random();
    }

    public String generateId(int length) {
        StringBuilder newId = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int randomIndex = this.rand.nextInt(this.alphanumeric.length());
            newId.append(this.alphanumeric.charAt(randomIndex));
        }
        return newId.toString();
    }

}
