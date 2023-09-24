package com.booleanuk.core.Bank;

import com.booleanuk.core.BaseEntity;
import com.booleanuk.core.Enums.Status;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Getter
@Setter
public class OverdraftRequest extends BaseEntity {
    private Status status;
    private BigDecimal amount;

    public OverdraftRequest(Status status, BigDecimal amount) {
        this.status = status;
        this.amount = amount;
    }
}
