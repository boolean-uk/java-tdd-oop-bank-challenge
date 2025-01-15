package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestTransaction {
    @Test
    public void canCreateTransaction() {
        double amount = 1000;
        double currentBalance = 100;
        LocalDateTime dt = LocalDateTime.now();
        Transaction t = new Transaction(amount, currentBalance + amount, dt);
        assertEquals(1000, t.getAmount());
        assertEquals(1100, t.getCurrentBalance());
        assertEquals(dt, t.getDateTime());
    }
}
