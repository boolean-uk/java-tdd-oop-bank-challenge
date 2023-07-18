package com.booleanuk.core.user;

import com.booleanuk.core.banking.BankAccountAlreadyExistsException;
import com.booleanuk.core.banking.CurrentAccount;
import com.booleanuk.core.banking.SavingAccount;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Customer extends User implements CustomerOperations {
    private final UUID uuid;
    private CurrentAccount currentAccount;
    private SavingAccount savingAccount;

    public Customer() {
        this.uuid = UUID.randomUUID();
        this.currentAccount = null;
        this.savingAccount = null;
    }

    @Override
    public Boolean openCurrentAccount() {
        if (Objects.nonNull(this.currentAccount)) {
            throw new BankAccountAlreadyExistsException("You have opened Current Account with ID: " + currentAccount.getUuid());
        }
        this.currentAccount = new CurrentAccount();
        return true;
    }

    @Override
    public Boolean openSavingAccount() {
        if (Objects.nonNull(this.savingAccount)) {
            throw new BankAccountAlreadyExistsException("You have opened Saving Account with ID: " + savingAccount.getUuid());
        }
        this.savingAccount = new SavingAccount();
        return true;
    }
}
