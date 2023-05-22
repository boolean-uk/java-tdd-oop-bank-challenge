package com.booleanuk.core;

import java.math.BigDecimal;

public class OverdraftRequest {

    private Account account;
    private BigDecimal amount;
    private Bank.OverdraftStatus status;

    public OverdraftRequest(Account account, double amount) {
        this.account = account;
        this.amount = BigDecimal.valueOf(amount);
        status = Bank.OverdraftStatus.PENDING;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bank.OverdraftStatus getStatus() {
        return status;
    }

    public void setStatus(Bank.OverdraftStatus status) {
        this.status = status;
    }
}
