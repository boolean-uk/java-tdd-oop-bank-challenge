package com.booleanuk.core.user;

import com.booleanuk.core.banking.TransactionDetails;
import com.booleanuk.core.banking.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Engineer extends Customer {

    private BigDecimal balance;


    public Engineer() {
        super();
    }

    public BigDecimal calculateBalanceFromHistory() {
        BigDecimal internalBalance = BigDecimal.ZERO;
        List<TransactionDetails> transactions = getCurrentAccount().getTransactions();

        for (TransactionDetails transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.WITHDRAW)) {
                internalBalance = internalBalance.subtract(transaction.getAmount());
            }
            if (transaction.getTransactionType().equals(TransactionType.DEPOSIT)) {
                internalBalance = internalBalance.add(transaction.getAmount());
            }

        }

        return internalBalance;
    }
}
