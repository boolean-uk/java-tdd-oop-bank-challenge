package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.OverdraftRequest;
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
            OverdraftRequest overdraftRequest = currentAccount.getOverdraftRequest();

            if (overdraftRequest != null && overdraftRequest.getStatus().equals(Status.Pending)) {
                BigDecimal balanceThreshold = currentAccount.getBalance().multiply(BigDecimal.valueOf(3.50));
                BigDecimal requestedAmount = overdraftRequest.getAmount();

                if (balanceThreshold.compareTo(requestedAmount) >= 0) {
                    overdraftRequest.setStatus(Status.Approved);
                } else {
                    overdraftRequest.setStatus(Status.Rejected);
                }
            }
        }
    }
}
