package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcceptanceTest {
    @Test
    public void passesAcceptanceCriteria() {
        // See previous commits for when this class had easily distinguishable dates
        Bank bank = new Bank();
        int accountNum = bank.createAccount(AccountType.CURRENT);
        Assertions.assertEquals(0, bank.getAccountBalance(accountNum));
        // Client makes a deposit of 1000
        bank.performDeposit(accountNum, 1000);
        Assertions.assertEquals(1000, bank.getAccountBalance(accountNum));
        // Client makes a deposit of 2000
        bank.performDeposit(accountNum, 2000);
        Assertions.assertEquals(3000, bank.getAccountBalance(accountNum));
        // Client makes a withdrawal of 500
        bank.performWithdrawal(accountNum, 500);
        Assertions.assertEquals(2500, bank.getAccountBalance(accountNum));
        // Client prints her bank statement (check terminal)
        System.out.println(bank.getAccountBankStatement(accountNum));
    }
}
