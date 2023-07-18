package com.booleanuk.core.banking;

import java.math.BigDecimal;

interface BankOperations {
    BankTransaction deposit(BigDecimal deposit);

    BankTransaction withdraw(BigDecimal withdraw);

    String generateBankStatements();

    Boolean payWithCard(BigDecimal amount);

    Boolean payOnline(BigDecimal amount);
}
