package com.booleanuk.core.user;

import com.booleanuk.core.banking.BankTransaction;

import java.math.BigDecimal;

interface CustomerOperations {
    Boolean openCurrentAccount();

    Boolean openSavingAccount();

    BankTransaction depositCurrentAccount(BigDecimal bigDecimal);

    BankTransaction withdrawCurrentAccount(BigDecimal bigDecimal);

    BankTransaction depositSavingAccount(BigDecimal bigDecimal);

    BankTransaction withdrawSavingAccount(BigDecimal bigDecimal);
}
