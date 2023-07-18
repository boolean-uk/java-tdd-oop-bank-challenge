package com.booleanuk.extension;

import java.math.BigDecimal;

public class Overdraft {

    private final BigDecimal amount;
    private boolean approved;
    private boolean pending;

    public Overdraft(BigDecimal amount) {
        this.amount = amount;
        this.pending = true;
        this.approved = false;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void approve() {
        this.approved = true;
        this.pending = false;
    }

    public void reject() {
        this.approved = false;
        this.pending = false;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isPending() {
        return pending;
    }
}
