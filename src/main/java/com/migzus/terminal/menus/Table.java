package com.migzus.terminal.menus;

import java.util.ArrayList;

public class Table {
    private final ArrayList<ArrayList<String>> table = new ArrayList<>();
    private final ArrayList<String> titles = new ArrayList<>();

    private int columns;
    private int rows;

    public void pushColumn(String title) {
        titles.add(title);
        table.add(new ArrayList<>());
        columns++;
    }

    public void pushRow(String...elms) {
        int _index = 0;

        for (String elm : elms) {
            if (_index >= columns) break;
            table.get(_index).add(elm);
            _index++;
        }

        rows++;
    }

    public String toString() {
        final StringBuilder _sb = new StringBuilder();
        final ArrayList<Integer> _longestColumns = new ArrayList<>();

        for (int i = 0; i < columns; i++) {
            _longestColumns.add(titles.get(i).length());

            for (String elm : table.get(i))
                _longestColumns.set(i, Math.max(_longestColumns.get(i), elm.length()));
        }

        for (int i = 0; i < columns; i++)
            _sb.append(" ").append(titles.get(i)).append(" ".repeat(_longestColumns.get(i) - titles.get(i).length())).append(" |");

        _sb.append("\n");

        for (int length : _longestColumns)
            _sb.append("-".repeat(length)).append("---");

        _sb.append("\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String _elm = table.get(j).get(i);
                _sb.append(" ").append(_elm).append(" ".repeat(_longestColumns.get(j) - _elm.length())).append(" |");
            }

            _sb.append("\n");
        }

        return _sb.toString();
    }
}
