package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class TransferTest {
    private Transfer transfer;
    @BeforeEach
    public void setup() {
        transfer = new Transfer(30000, LocalDate.parse("2023-07-18"));
    }

    @Test
    public void transferGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals(30000, transfer.getAmountOfMoney());
        Assertions.assertEquals(2023, transfer.getDate().getYear());
        Assertions.assertEquals(7, transfer.getDate().getMonth().getValue());
        Assertions.assertEquals(18, transfer.getDate().getDayOfMonth());

    }
}
