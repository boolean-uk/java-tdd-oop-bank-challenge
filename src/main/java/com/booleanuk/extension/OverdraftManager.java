package com.booleanuk.extension;

import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.OverdraftRequestException;
import com.booleanuk.extension.models.OverdraftRequest;
import lombok.Data;

@Data
public class OverdraftManager {
    public static void requestOverdraft(OverdraftRequest request) throws InsufficientFundsException, OverdraftRequestException {
        // Check if account with a maximum overdraft
        if (request.getAccount().getMaximumOverdraft() == 0) {
            throw new InsufficientFundsException();
        }
        // Check if new account balance would dip below the maximum overcharge
        double balanceAfter = request.getAccount().getBalanceFromTransactions() - request.getAmount();
        if (balanceAfter < -request.getAccount().getMaximumOverdraft()) {
            throw new OverdraftRequestException();
        }
        // TODO Additional logic/input to approve or deny overdraft requests
    }
}
