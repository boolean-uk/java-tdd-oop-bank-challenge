package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankStatement {

    public static String generate(List<Transaction> transactions){
        StringBuilder sb = new StringBuilder();
        sb.append(createFooter());

        BigDecimal initialBalance = BigDecimal.ZERO;
        List<String> rows = new ArrayList<>();
        for(Transaction transaction : transactions){
            String[] info = transaction.toString().split(",");
            initialBalance = initialBalance.add(transaction.getAmount());
            rows.add(createRow(
                    createCell(info[0]),
                    createCell(info[1]),
                    createCell(info[2]),
                    createCell(String.format("%.2f", initialBalance))
            ));
        }

        for(int i = rows.size()-1; i >= 0; i--) sb.append(rows.get(i));
        return sb.toString();
    }

    private static String createCell(String content){
        return String.format("%-11.11s ", content);
    }

    private static String createRow(String... cells){
        StringBuilder row = new StringBuilder();
        for(int i = 0; i < cells.length - 1; i++){
            row.append(cells[i]);
            row.append("|| ");
        }
        row.append(cells[cells.length-1]);
        row.append('\n');

        return row.toString();
    }

    private static String createFooter(){
        return createRow(
                createCell("Date"),
                createCell("Credit"),
                createCell("Debit"),
                createCell("Balance")
        );
    }

}
