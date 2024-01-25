package com.booleanuk.core.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyUtils {
    /**
     * Converts the amount of subunits (cents, pennies, etc.) to base units (dollar, pound, etc.)
     * @param amount the amount of subunits
     * @return the amount in base units
     */
    public static double toBaseUnits(int amount) {
        return amount / 100.0;
    }

    /**
     * Converts the amount of base units (dollar, pound, etc.) to subunits (cents, pennies, etc.)
     * @param amount the amount of base units
     * @return the amount in subunits
     */
    public static int toSubUnits(double amount) {
        BigDecimal decimalAmount = BigDecimal.valueOf(amount);
        BigDecimal subUnits = decimalAmount.multiply(BigDecimal.valueOf(100));
        return subUnits.setScale(0, RoundingMode.HALF_UP).intValue();
    }
}
