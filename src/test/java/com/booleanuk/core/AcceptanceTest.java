package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AcceptanceTest {
    @Test
    public void passesAcceptanceCriteria() {
        Bank bank = new Bank();
        int accountNum = bank.createAccount(AccountType.CURRENT);
        Assertions.assertEquals(0, bank.getAccountBalance(accountNum));
        // Client makes a deposit of 1000 on 10-01-2012
        bank.performDeposit(accountNum, 1000, LocalDateTime.of(2012, 1, 10, 14, 22));
        Assertions.assertEquals(1000, bank.getAccountBalance(accountNum));
        // Client makes a deposit of 2000 on 13-01-2012
        bank.performDeposit(accountNum, 2000, LocalDateTime.of(2012, 1, 13, 10, 47));
        Assertions.assertEquals(3000, bank.getAccountBalance(accountNum));
        // Client makes a withdrawal of 500 on 14-01-2012
        bank.performWithdrawal(accountNum, 500, LocalDateTime.of(2012, 1, 14, 18, 11));
        Assertions.assertEquals(2500, bank.getAccountBalance(accountNum));
        // Client prints her bank statement (check terminal)
        System.out.println(bank.getAccountBankStatement(accountNum));
    }
}
