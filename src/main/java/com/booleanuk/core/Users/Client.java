package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Client extends User {
    private Account currentAccount;
    private Account savingsAccount;

    public Client(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.currentAccount = null;
        this.savingsAccount = null;
    }

    public boolean openSavingsAccount(SavingsAccount savingsAccount) {
        if (this.savingsAccount != null) {
            System.out.printf("You already have a savings account (Account id: %s).\n",this.savingsAccount.getId());
            return false;
        } else {
            this.savingsAccount = savingsAccount;
            return true;
        }
    }

    public boolean openCurrentAccount(CurrentAccount currentAccount) {
        if (this.currentAccount != null) {
            System.out.printf("You already have a current account (Account id: %s).\n",this.currentAccount.getId());
            return false;
        } else {
            this.currentAccount = currentAccount;
            return true;
        }
    }

    public boolean requestOverdraft(Account account, BigDecimal amount) {
        return false;
    }
}
