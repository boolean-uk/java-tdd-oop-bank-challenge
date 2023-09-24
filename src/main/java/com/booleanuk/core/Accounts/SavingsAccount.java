package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Enums.TransactionType;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingsAccount extends Account {
    private final BigDecimal interestRate = BigDecimal.valueOf(3.01);
    private final BigDecimal initialDepositMinimum = BigDecimal.valueOf(1500);

    public SavingsAccount(BigDecimal balance, Branch branch, User accountHolder) {

        super(balance, branch, accountHolder);
        if (balance.compareTo(this.initialDepositMinimum) < 0) {
            throw new IllegalArgumentException("Savings account must be opened with a minimum deposit of " + initialDepositMinimum);
        }
    }

    @Override
    public boolean requestOverdraft(BigDecimal amount) {
        System.out.println("You cannot request an overdraft on your savings account!");
        return false;
    }

    public Transaction withdrawFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for withdrawal.");
        }

        BigDecimal newBalance = this.getBalance().subtract(amount);

        if (newBalance.compareTo(this.initialDepositMinimum) < 0) {
            throw new IllegalArgumentException(String.format("You balance cannot go below the limit of %s", ((SavingsAccount) this).getInitialDepositMinimum()));
        }

        Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount);
        transactions.add(withdrawTransaction);
        return withdrawTransaction;
    }
}
