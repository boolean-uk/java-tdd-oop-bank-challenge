package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.math.BigDecimal.*;

public class Transaction {

    private LocalDateTime createdAt;
    private BigDecimal debit;

    private BigDecimal credit;

    private BigDecimal currentBalance;



    public Transaction( BigDecimal value, BigDecimal currentBalance) {
        createdAt = LocalDateTime.now();
        if(value.doubleValue() > ZERO.doubleValue()){
            credit = value;
            debit = ZERO;
        } else if (value.doubleValue() < ZERO.doubleValue()) {
            debit = value;
            credit=ZERO;
        }
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getCurrentBalance(){
        return currentBalance;
    }
}
