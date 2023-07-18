package com.booleanuk.core.banking;

import java.math.BigDecimal;

interface BankOperations {
    TransactionDetails deposit(BigDecimal deposit);

    TransactionDetails withdraw(BigDecimal withdraw);

    String generateBankStatements();

    Boolean payWithCard(BigDecimal amount);

    Boolean payOnline(BigDecimal amount);
}
