package com.booleanuk.core;

import java.math.BigDecimal;

public class Overdraft {
    private String status;
    private BigDecimal limit;


    public Overdraft() {
        this.status = "nothing";
        this.limit = new BigDecimal("0.00");
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getLimit() {
        return limit;
    }
}
