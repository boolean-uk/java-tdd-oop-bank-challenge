package com.booleanuk.core.banking;

import java.math.BigDecimal;

interface BankOperations {
    Boolean deposit(BigDecimal deposit);

    Boolean withdraw(BigDecimal withdraw);

    String generateBankStatements();

    Boolean payWithCard(BigDecimal amount);

    Boolean payOnline(BigDecimal amount);
}
