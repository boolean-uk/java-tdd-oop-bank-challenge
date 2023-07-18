package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OverdraftTest {
    Overdraft overdraft;

    @BeforeEach
    void setUp() {
        overdraft = new Overdraft(BigDecimal.valueOf(1000.00));
    }

    @Test
    void shouldBePendingAndNotApproved() {
        Assertions.assertTrue(overdraft.isPending());
        Assertions.assertFalse(overdraft.isApproved());
    }

    @Test
    void shouldBeNotPendingAndApproved() {
        overdraft.approve();
        Assertions.assertFalse(overdraft.isPending());
        Assertions.assertTrue(overdraft.isApproved());
    }
    
    @Test
    void shouldBeNotPendingAndRejected() {
        overdraft.reject();
        Assertions.assertFalse(overdraft.isPending());
        Assertions.assertFalse(overdraft.isApproved());
    }
}
