package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SavingAccount extends Account {
    private BigDecimal interestRate;

    public SavingAccount(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Interest rate must be nonnegative");
        this.interestRate = interestRate;
    }

    public void addInterests(LocalDate date) {
        BigDecimal balance = getBalance();
        BigDecimal multiplier = interestRate.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

        BigDecimal amount = balance.multiply(multiplier);
        addTransaction(amount, date);
    }
}
