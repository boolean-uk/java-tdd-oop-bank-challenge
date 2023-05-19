package com.booleanuk.core.statement;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<String> data;
    public Cell(List<String> data) {
        this.data = new ArrayList<>(data);
    }

    public void updateColumn(int column, String data) {

    }

    public String asString(int width) {
        return "";
    }
}
