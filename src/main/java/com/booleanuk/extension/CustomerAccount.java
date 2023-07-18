package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CustomerAccount {

    public AccountType getAccountType() {
        return accountType;
    }

    private AccountType accountType;

    public HashMap<String, BigDecimal> getBalanceHistory() {
        return balanceHistory;
    }

    public void setBalanceHistory(HashMap<String, BigDecimal> balanceHistory) {
        this.balanceHistory = balanceHistory;
    }

    private HashMap<String, BigDecimal> balanceHistory;

    public CustomerAccount(AccountType accountType){
        this.accountType = accountType;
        this.balanceHistory = new HashMap<String, BigDecimal>(5);
    }

    BigDecimal transactionID = BigDecimal.ZERO;

    public void transaction(BigDecimal amount, boolean isDeposit) {

        LocalDateTime formatter = LocalDateTime.now();
        DateTimeFormatter dateFormatterPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SS");
        String currentDate = formatter.format(dateFormatterPattern);
        String transactionKey = currentDate + transactionID.toString();


        if (isDeposit==true){
            balanceHistory.put(transactionKey, amount);
        }
        else {
            balanceHistory.put(transactionKey, amount.multiply(BigDecimal.valueOf(-1)));
        }
        transactionID = transactionID.add(BigDecimal.ONE);
    }

    public BigDecimal totalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (BigDecimal amount : balanceHistory.values()) {
            totalBalance = totalBalance.add(amount);
        }
        return totalBalance;
    }
    public StringBuilder printStatement() {
        StringBuilder statement = new StringBuilder();
        final BigDecimal[] totalBalance = {BigDecimal.ZERO};

        statement.append("\n    Date and time   || Operation type || Balance\n");
        for (String date : balanceHistory.keySet()) {
            BigDecimal amount = balanceHistory.get(date);

            String operationType = amount.compareTo(BigDecimal.ZERO) > 0 ? "   Deposit     " : "  Withdrawal   ";
            statement.append(date.substring(0, 19) + " || " + operationType + "|| £" + amount + "\n");
        }

        statement.append("------------------------- Total balance: £" + totalBalance()+"\n");
        return statement;
    }

}