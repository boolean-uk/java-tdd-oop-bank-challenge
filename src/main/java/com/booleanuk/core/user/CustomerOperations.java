package com.booleanuk.core.user;

import com.booleanuk.core.banking.TransactionDetails;

import java.math.BigDecimal;

interface CustomerOperations {
    Boolean openCurrentAccount();

    Boolean openSavingAccount();

    TransactionDetails depositCurrentAccount(BigDecimal depositAmount);

    TransactionDetails withdrawCurrentAccount(BigDecimal bigDecimal);

    TransactionDetails depositSavingAccount(BigDecimal bigDecimal);

    TransactionDetails withdrawSavingAccount(BigDecimal bigDecimal);

    String generateCurrentAccountStatements();

    String generateSavingAccountStatements();

    void changeEmergencyFund(BigDecimal increaseAmount);
}
