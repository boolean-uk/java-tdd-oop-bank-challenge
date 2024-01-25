package com.booleanuk.extension.models;

import com.booleanuk.core.models.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OverdraftRequest {
    private Account account;
    private double amount;
}
