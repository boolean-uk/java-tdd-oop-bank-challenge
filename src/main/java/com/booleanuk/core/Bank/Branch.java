package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Manager;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Branch {
    private Branches branchLocation;
    private Manager manager;
    private List<Account> accounts;

    public Branch(Branches branchLocation, Manager manager) {
        this.accounts = new ArrayList<>();
        this.branchLocation = branchLocation;
        this.manager = manager;
    }

    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return accounts.stream()
                .filter(account -> account instanceof SavingsAccount)
                .map(account -> (SavingsAccount) account)
                .collect(Collectors.toList());
    }
    public List<CurrentAccount> getCurrentAccounts() {
        return accounts.stream()
                .filter(account -> account instanceof CurrentAccount)
                .map(account -> (CurrentAccount) account)
                .collect(Collectors.toList());
    }
}
