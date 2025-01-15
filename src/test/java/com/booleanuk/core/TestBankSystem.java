package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBankSystem {
    @Test
    public void approvingOverdraftRequestWorksCorrectly() {
        BankSystem bs = new BankSystem();
        SavingsAccount account = new SavingsAccount("12345678", "123456");
        bs.addSavingsAccount(account);
        OverdraftRequest or = new OverdraftRequest(account.getAccountNumber(), account.getBranchNumber(), 500);
        bs.approve(or);
        assertTrue(account.hasOverdraft());
    }
}
