package com.migzus.terminal.menus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static boolean isZeroApprox(double value) {
        return isZeroApprox(value, 0.0000001);
    }

    public static boolean isZeroApprox(double value, double delta) {
        return value < delta && value > -delta;
    }

    public static String getDateTimeNow() {
        return getNow("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateNow() {
        return getNow("yyyy-MM-dd");
    }

    public static String getNow(String format) {
        return DateTimeFormatter.ofPattern(format).format(LocalDateTime.now());
    }
}
