package com.booleanuk.core.user;

import com.booleanuk.core.banking.TransactionDetails;
import com.booleanuk.core.banking.CurrentAccount;
import com.booleanuk.core.banking.SavingAccount;
import com.booleanuk.core.exception.BankAccountAlreadyExistsException;
import com.booleanuk.core.exception.BankAccountNotOpenedException;
import com.booleanuk.core.sms.TwillioService;
import com.booleanuk.core.statement.BankStatementGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer extends User implements CustomerOperations {

    private final TwillioService twillioService;
    private CurrentAccount currentAccount;
    private SavingAccount savingAccount;
    private String phoneNumber;

    public Customer() {
        super();
        this.currentAccount = null;
        this.savingAccount = null;
        this.twillioService = new TwillioService();
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
    public TransactionDetails depositCurrentAccount(BigDecimal depositAmount) {
        if (Objects.isNull(currentAccount)) {
            throw new BankAccountNotOpenedException("Current Account not opened");
        }

        return currentAccount.deposit(depositAmount);
    }

    @Override
    public TransactionDetails depositSavingAccount(BigDecimal depositAmount) {
        if (Objects.isNull(savingAccount)) {
            throw new BankAccountNotOpenedException("Saving Account not opened");
        }

        return savingAccount.deposit(depositAmount);
    }

    @Override
    public TransactionDetails withdrawCurrentAccount(BigDecimal withdrawAmount) {
        if (Objects.isNull(currentAccount)) {
            throw new BankAccountNotOpenedException("Current Account not opened");
        }

        return currentAccount.withdraw(withdrawAmount);
    }

    @Override
    public TransactionDetails withdrawSavingAccount(BigDecimal withdrawAmount) {
        if (Objects.isNull(savingAccount)) {
            throw new BankAccountNotOpenedException("Saving Account not opened");
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

    @Override
    public void changeEmergencyFund(BigDecimal newEmergencyFund) {
        if (Objects.isNull(currentAccount)) {
            throw new BankAccountNotOpenedException("Current Account not opened");
        }
        if (newEmergencyFund.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Your emergency fund cannot be negative");
        }
        currentAccount.setEmergencyFund(newEmergencyFund);
    }

}
