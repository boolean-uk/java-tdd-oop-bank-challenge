package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.OverdraftRequest;
import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Enums.TransactionType;
import com.booleanuk.core.Users.Client;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class CurrentAccount extends Account {
    private OverdraftRequest overdraftRequest;

    public CurrentAccount(BigDecimal initialBalance, Branch branch, Client accountHolder) {
        super(initialBalance, branch, accountHolder);
        this.overdraftRequest = null;
    }

    @Override
    public boolean requestOverdraft(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.setOverdraftRequest(new OverdraftRequest(Status.Pending, amount));
            return true;
        } else {
            throw new IllegalArgumentException("The requested amount must be a positive number!");
        }
    }

    public Transaction withdrawFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for withdrawal.");
        }

        BigDecimal newBalance = this.getBalance().subtract(amount);

        if (this.getOverdraftRequest()!=null && this.getOverdraftRequest().getStatus().equals(Status.Approved)) {
            BigDecimal overdraftLimit = this.getOverdraftRequest().getAmount();
            if (newBalance.compareTo(overdraftLimit.negate()) < 0) {
                throw new IllegalArgumentException("Exceeds overdraft limit.");
            }
        } else if (newBalance.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException("Your balance on this account cannot be negative.");
        }

        Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount);
        this.transactions.add(withdrawTransaction);
        return withdrawTransaction;
    }
}
