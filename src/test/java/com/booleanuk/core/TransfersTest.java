package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransfersTest {
    private Transfer transfer;
    private Deposit deposit;

    @BeforeEach
    public void setup() {
        transfer = new Transfer(30000, LocalDate.parse("2023-07-18"));
        deposit = new Deposit(30000, LocalDate.parse("2023-07-18"));
    }

    @Test
    public void transferGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals(30000, transfer.getAmountOfMoney());
        Assertions.assertEquals(2023, transfer.getDate().getYear());
        Assertions.assertEquals(7, transfer.getDate().getMonth().getValue());
        Assertions.assertEquals(18, transfer.getDate().getDayOfMonth());

        transfer.setAmountOfMoney(40000);
        transfer.setDate(LocalDate.parse("2023-08-19"));

        Assertions.assertEquals(40000, transfer.getAmountOfMoney());
        Assertions.assertEquals(2023, transfer.getDate().getYear());
        Assertions.assertEquals(8, transfer.getDate().getMonth().getValue());
        Assertions.assertEquals(19, transfer.getDate().getDayOfMonth());
    }

    @Test
    public void depositGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals(30000, deposit.getAmountOfMoney());
        Assertions.assertEquals(2023, deposit.getDate().getYear());
        Assertions.assertEquals(7, deposit.getDate().getMonth().getValue());
        Assertions.assertEquals(18, deposit.getDate().getDayOfMonth());

        deposit.setAmountOfMoney(40000);
        deposit.setDate(LocalDate.parse("2023-08-19"));

        Assertions.assertEquals(40000, deposit.getAmountOfMoney());
        Assertions.assertEquals(2023, deposit.getDate().getYear());
        Assertions.assertEquals(8, deposit.getDate().getMonth().getValue());
        Assertions.assertEquals(19, deposit.getDate().getDayOfMonth());
    }
}
