package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankStatement {

    private Account account;

    public BankStatement(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void print(){
        System.out.println(createFooter());
        BigDecimal initialBalance = BigDecimal.ZERO;
        List<String> rows = new ArrayList<>();
        for(Transaction transaction : account.getTransactions()){
            String[] info = transaction.toString().split(",");
            initialBalance = initialBalance.add(transaction.getAmount());
            rows.add(createRow(
                    createCell(info[0]),
                    createCell(info[1]),
                    createCell(info[2]),
                    createCell(String.format("%.2f", initialBalance))
            ));

        }
        for(int i = rows.size()-1; i  >=0; i--) System.out.println(rows.get(i));
    }
    public void print(LocalDateTime fromDate, LocalDateTime toDate){

    }

    private String createCell(String content){
        return String.format("%-11.11s ", content);
    }

    private String createRow(String ...cells){
        StringBuilder row = new StringBuilder();
        for(int i = 0; i < cells.length - 1; i++){
            row.append(cells[i]);
            row.append("|| ");
        }
        row.append(cells[cells.length-1]);
        row.append('\n');

        return row.toString();
    }

    private String createFooter(){
        return createRow(
                createCell("Date"),
                createCell("Credit"),
                createCell("Debit"),
                createCell("Balance")
        );
    }



}
