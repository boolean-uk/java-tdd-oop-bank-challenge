package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    CurrentAccount currentAccount;
    SavingAccount savingAccount;
    List<Transaction> transactions;

    public Bank(String branchID) {
        this.currentAccount = new CurrentAccount(BigDecimal.valueOf(0),branchID);
        this.savingAccount = new SavingAccount(BigDecimal.valueOf(0),branchID);
        transactions = new ArrayList<>();
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            this.savingAccount.deposit(bigDecimal);
        } else {
            this.savingAccount.withdraw(bigDecimal.abs());
        }
    }

    public void setCurrentAccount(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            this.currentAccount.deposit(bigDecimal);
        } else {
            this.currentAccount.withdraw(bigDecimal.abs());
        }
    }

    public String makeNewTransaction(BigDecimal transactionAmount, Transaction.accountType type) {
        transactions.add(new Transaction(transactionAmount, type));
        if(type.equals( Transaction.accountType.CREDIT)){
            setSavingAccount(transactionAmount);
        }else{
            setCurrentAccount(transactionAmount);
        }
//       System.out.println(generateTransactionsSummary
//               (transactions,currentAccount.amount.add(savingAccount.amount)));
        return generateTransactionsSummary();
    }
    public BigDecimal getBalance(){
        return getCurrentAccount().amount.add(getSavingAccount().amount);
    }

    public  String generateTransactionsSummary() {
        var format = "%-15s|| %-15s|| %-15s|| %-15s\n";
        var sb = new StringBuilder();
        sb.append(String.format(format, "date", "DEBIT", "CREDIT", "balance"));
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);
        BigDecimal amount =BigDecimal.ZERO;
        BigDecimal balance = getSavingAccount().amount.add(getCurrentAccount().amount);
        for (var t : reversed) {
            var date = t.dateTime.toLocalDate();
            var type = t.type;
            BigDecimal amountD = null;
            BigDecimal amountC = null;
            if (type.equals(Transaction.accountType.DEBET)) {
                amountD = t.amount;
            } else {
                amountC = t.amount;
            }
            sb.append(String.format(format, date, amountD, amountC, balance.subtract(amount)));
            amount = t.amount;

        }
        return sb.toString().replace("null", " ".repeat(4));
    }
public  void sendMessage(String recipientPhoneNumber){
    var message = generateTransactionsSummary();

    TwilioService.sendSmsMessage(recipientPhoneNumber, message);
}

    public static void main(String[] args) {
        Bank bank=new Bank("WAR");
        bank.makeNewTransaction(BigDecimal.valueOf(500), Transaction.accountType.DEBET);
       // bank.sendMessage("48722362249");
    }

}