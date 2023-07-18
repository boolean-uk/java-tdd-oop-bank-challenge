package com.booleanuk.core;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double value = 12345.6789;
        DecimalFormat df = new DecimalFormat("0.00"); // use this format
        String str = df.format(value);
        System.out.println(str); // prints 12345.68
    }
}
