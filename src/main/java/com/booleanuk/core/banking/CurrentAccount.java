package com.booleanuk.core.banking;


import com.booleanuk.core.exception.EmergencyFundExceededException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrentAccount extends BankAccount {
    private BigDecimal emergencyFund = BigDecimal.ZERO;

    @Override
    public BankTransaction withdraw(BigDecimal withdrawAmount) {
        BigDecimal newBalance = getBalance().subtract(withdrawAmount);
        if (isEmergencyFundActive() && willEmergencyFundBeExceeded(newBalance)) {
            throw new EmergencyFundExceededException("Your emergency fund exceeded");
        }

        return super.withdraw(withdrawAmount);
    }

    private boolean willEmergencyFundBeExceeded(BigDecimal newBalance) {
        return newBalance.compareTo(emergencyFund) < 0;
    }

    private boolean isEmergencyFundActive() {
        return emergencyFund.compareTo(BigDecimal.ZERO) > 0;
    }
}
