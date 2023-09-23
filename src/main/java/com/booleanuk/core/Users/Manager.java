package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Manager extends User{
    private Branch branch;
    public Manager(String name, String phoneNumber, Branch branch) {
        super(name, phoneNumber);
        this.setBranch(branch);
    }

    public void reviewOverdraftRequests() {
        List<CurrentAccount> currentAccounts = branch.getCurrentAccounts();
        for (CurrentAccount currentAccount : currentAccounts) {
            if (currentAccount.getOverdraftStatus().equals(Status.Pending)) {
                BigDecimal balanceThreshold = currentAccount.getBalance().multiply(BigDecimal.valueOf(3.50));
                BigDecimal overdraftLimit = currentAccount.getOverdraftLimit();
                double res = balanceThreshold.compareTo(overdraftLimit);
                if (overdraftLimit != null && balanceThreshold.compareTo(overdraftLimit) >= 0) {
                    currentAccount.setOverdraftStatus(Status.Approved);
                } else {
                    currentAccount.setOverdraftStatus(Status.Rejected);
                    currentAccount.setOverdraftLimit(BigDecimal.ZERO);

                }
            }
        }
    }
}
