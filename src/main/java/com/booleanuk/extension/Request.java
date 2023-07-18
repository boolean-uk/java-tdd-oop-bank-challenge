package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.booleanuk.extension.Request.Status.*;

public class Request {
    private UUID customerId;
    private UUID accountId;
    private BigDecimal overdraftAmount;
    private LocalDateTime dateTime;
    private Status status;

    public Request(UUID customerId, UUID accountId, BigDecimal overdraftAmount) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.overdraftAmount = overdraftAmount;
        dateTime = LocalDateTime.now();
        status = PENDING;
    }

    public void accept() {
        status = ACCEPTED;
    }

    public void reject() {
        status = REJECTED;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getOverdraftAmount() {
        return overdraftAmount;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}