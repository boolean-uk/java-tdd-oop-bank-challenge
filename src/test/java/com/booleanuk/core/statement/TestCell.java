package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCell {
    @Test
    public void testUpdateCell() {
        Cell c = new Cell(List.of("one", "two", "three"));

        c.updateColumn(0, "zero");

        String r = c.asString(1);
        String expected = "zero||two||three||";

        Assertions.assertEquals(expected, r);
    }

    @Test
    public void testAsString() {
        Cell c = new Cell(List.of("one", "two", "three"));

        String r = c.asString(10);
        String expected = "       one||       two||     three||";

        Assertions.assertEquals(expected, r);
    }
}
