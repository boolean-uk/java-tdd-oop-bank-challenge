package com.booleanuk.extension.account;

import com.booleanuk.extension.TwilioService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class Account {
    protected final List<Transaction> transactions = new ArrayList<>();
    protected final SwiftCode swiftCode;

    public BigDecimal balance() {
        return transactions.stream()
                .filter(t -> t.status().equals(Transaction.Status.Accepted))
                .map(t -> {
                    var modifier = BigDecimal.valueOf(t.type().getModifier());
                    return t.amount().multiply(modifier);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void deposit(BigDecimal amount) {
        transactions.add(Transaction.of(Transaction.Type.Deposit, amount, Transaction.Status.Accepted));
    }

    public void withdraw(BigDecimal amount) {
        var status = balance().compareTo(amount) >= 0 ?
                Transaction.Status.Accepted :
                Transaction.Status.Rejected;

        transactions.add(Transaction.of(Transaction.Type.Withdrawal, amount, status));
    }

    public String generateStatement() {
        List<String> transactionEntries = new ArrayList<>();
        var sb = new StringBuilder();
        sb.append(String.format(
                "|| %10s || %10s || %10s || %10s || %10s ||\n",
                "Date", "Status", "Credit", "Debit", "Balance"
        ));

        var statementBalance = BigDecimal.ZERO;
        for (var t : this.transactions) {
            var isAccepted = t.status().equals(Transaction.Status.Accepted);
            if (isAccepted) {
                var modifier = BigDecimal.valueOf(t.type().getModifier());
                statementBalance = statementBalance.add(t.amount().multiply(modifier));
            }
            transactionEntries.add(String.format("%s %10.2f ||\n", t, statementBalance));
        }
        Collections.reverse(transactionEntries);
        transactionEntries.forEach(sb::append);

        return sb.toString();
    }

    public void sendStatementAsSms(String recipientNumber) {
        var sms = generateStatement();
        TwilioService.sendSms(recipientNumber, sms);
    }
}
