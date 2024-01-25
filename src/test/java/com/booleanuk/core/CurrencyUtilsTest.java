package com.booleanuk.core;

import com.booleanuk.core.util.CurrencyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyUtilsTest {
    @Test
    public void convertsToBaseUnits() {
        Assertions.assertEquals(34_567.34, CurrencyUtils.toBaseUnits(3456734));
        Assertions.assertEquals(34_500, CurrencyUtils.toBaseUnits(3450000));
    }

    @Test
    public void convertsToSubUnits() {
        Assertions.assertEquals(3456734, CurrencyUtils.toSubUnits(34_567.34));
        Assertions.assertEquals(3456000, CurrencyUtils.toSubUnits(34_560));
    }
}
