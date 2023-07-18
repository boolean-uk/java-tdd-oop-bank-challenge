package com.booleanuk.core.user;

import com.booleanuk.core.banking.CurrentAccount;
import com.booleanuk.core.banking.SavingAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Customer extends User implements CustomerOperations{
    private final UUID uuid;
    private final CurrentAccount currentAccount;
    private final SavingAccount savingAccount;

    @Override
    public Boolean openCurrentAccount() {
        return null;
    }

    @Override
    public Boolean openSavingAccount() {
        return null;
    }
}
