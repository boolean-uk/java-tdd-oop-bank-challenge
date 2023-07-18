package com.booleanuk.core.banking;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingAccount extends BankAccount {
    private final BigDecimal interestRate = BigDecimal.valueOf(2.37);
}
