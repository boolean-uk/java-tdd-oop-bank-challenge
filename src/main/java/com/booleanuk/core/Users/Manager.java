package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Manager extends User{
    private Branch branch;
    public Manager(String name, String phoneNumber, Branch branch) {
        super(name, phoneNumber);
        this.setBranch(branch);
    }

    public void reviewOverdraftRequests() {
        for (CurrentAccount currentAccount : branch.getCurrentAccounts()) {
            if (currentAccount.getOverdraftStatus().equals(Status.Pending)) {
                BigDecimal balanceThreshold = currentAccount.getBalance().multiply(BigDecimal.valueOf(3.50));
                if (balanceThreshold.compareTo(currentAccount.getOverdraftLimit()) >= 0) {
                    currentAccount.setOverdraftStatus(Status.Rejected);
                } else {
                    currentAccount.setOverdraftStatus(Status.Approved);
                }
            }
        }
    }
}
