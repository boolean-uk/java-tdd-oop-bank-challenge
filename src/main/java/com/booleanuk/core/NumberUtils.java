package com.booleanuk.core;

public class NumberUtils {
    public static float centsToPounds(int num){
        String string = floatFormatter((float) num/100f);
        return Float.parseFloat(string);
    }

    public static int poundsToCents(float num){
        return (int) (num*100f);
    }

    public static String floatFormatter(float num){
        return String.format("%.2f", num);
    }
}
