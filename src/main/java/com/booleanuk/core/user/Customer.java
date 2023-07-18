package com.booleanuk.core.user;

import com.booleanuk.core.banking.BankAccountAlreadyExistsException;
import com.booleanuk.core.banking.BankAccountNotOpened;
import com.booleanuk.core.banking.BankTransaction;
import com.booleanuk.core.banking.CurrentAccount;
import com.booleanuk.core.banking.SavingAccount;
import com.booleanuk.core.statement.BankStatementGenerator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

    @Override
    public BankTransaction depositCurrentAccount(BigDecimal depositAmount) {
        if (Objects.isNull(currentAccount)) {
            throw new BankAccountNotOpened("Current Account not opened");
        }

        return currentAccount.deposit(depositAmount);
    }

    @Override
    public BankTransaction depositSavingAccount(BigDecimal depositAmount) {
        if (Objects.isNull(savingAccount)) {
            throw new BankAccountNotOpened("Saving Account not opened");
        }

        return savingAccount.deposit(depositAmount);
    }

    @Override
    public BankTransaction withdrawCurrentAccount(BigDecimal withdrawAmount) {
        if (Objects.isNull(currentAccount)) {
            throw new BankAccountNotOpened("Current Account not opened");
        }

        return currentAccount.withdraw(withdrawAmount);
    }

    @Override
    public BankTransaction withdrawSavingAccount(BigDecimal withdrawAmount) {
        if (Objects.isNull(savingAccount)) {
            throw new BankAccountNotOpened("Saving Account not opened");
        }

        return savingAccount.withdraw(withdrawAmount);
    }

    @Override
    public String generateCurrentAccountStatements() {
        BankStatementGenerator generator = new BankStatementGenerator();
        return generator.generateStatement(currentAccount.getTransactions());
    }

    @Override
    public String generateSavingAccountStatements() {
        BankStatementGenerator generator = new BankStatementGenerator();
        return generator.generateStatement(savingAccount.getTransactions());
    }
}
