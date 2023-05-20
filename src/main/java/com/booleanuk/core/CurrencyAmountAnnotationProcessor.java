package com.booleanuk.core;

import java.lang.reflect.Field;

public class CurrencyAmountAnnotationProcessor {
    public static void process(Object obj){
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(CurrencyAmount.class)) {
                field.setAccessible(true);
                try {
                    double value = field.getDouble(obj);
                    if (value <= 0) {
                        throw new IllegalArgumentException("Value must be positive.");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
