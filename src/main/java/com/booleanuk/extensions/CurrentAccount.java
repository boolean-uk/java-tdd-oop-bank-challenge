package com.booleanuk.extensions;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

public class CurrentAccount extends Account {
    public static final BigDecimal MAX_OVERDRAFT = BigDecimal.valueOf(-500);
    public boolean overdraft = false;
    @Override
    public void withdraw(BigDecimal removeFromBalance) {
        if (!overdraft)
            throw new IllegalStateException("You cannot overdraft");
        if (getBalance().subtract(removeFromBalance).compareTo(MAX_OVERDRAFT) < 0) {
            throw new IllegalStateException("Your max overdraft is: " + MAX_OVERDRAFT);
        }
        getAccountOperations().add(new AccountOperation(LocalDateTime.now(), "debit", removeFromBalance));
    }
    public void askForOverDraft(){
        if (askManagerForOverDraftApproval(this))
            System.out.println("Your request has been accepted, you can overdraft the amount of: " + MAX_OVERDRAFT);
        else
            System.out.println("Your request has been accepted, you can overdraft the amount of: " + MAX_OVERDRAFT);
    }

    public boolean askManagerForOverDraftApproval(CurrentAccount currentAccount){
        Random random = new Random();
        return currentAccount.overdraft = random.nextBoolean();
    }
}
