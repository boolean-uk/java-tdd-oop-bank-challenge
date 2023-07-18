package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    private static Bank bank;
    @BeforeAll
    static void testSetup(){
        bank = new Bank("GDA");
    }
    @Test
    public void setSavingAccountDeposit(){
        bank = new Bank("GDA");
        bank.setSavingAccount(BigDecimal.valueOf(500));
        Assertions.assertEquals(BigDecimal.valueOf(500),bank.getSavingAccount().amount);
    }
    @Test
    public void setSavingAccountWithdraw(){
        bank = new Bank("GDA");
        bank.setSavingAccount(BigDecimal.valueOf(500));
        bank.setSavingAccount(BigDecimal.valueOf(-300));
        Assertions.assertEquals(BigDecimal.valueOf(200),bank.getSavingAccount().amount);
    }
    @Test
    public void setSavingAccountWithdrawTooMuch(){
        bank = new Bank("GDA");
        bank.setSavingAccount(BigDecimal.valueOf(500));

        assertThrows(IllegalArgumentException.class, () -> bank.setSavingAccount(BigDecimal.valueOf(-700)));

    }
    @Test
    public void setCurrentAccountDeposit(){
        bank = new Bank("GDA");
        bank.setCurrentAccount((BigDecimal.valueOf(500)));
        Assertions.assertEquals(BigDecimal.valueOf(500),bank.getCurrentAccount().amount);
    }
    @Test
    public void setCurrentAccountWithdraw(){
        bank = new Bank("GDA");
        bank.setCurrentAccount(BigDecimal.valueOf(500));
        bank.setCurrentAccount(BigDecimal.valueOf(-300));
        Assertions.assertEquals(BigDecimal.valueOf(200),bank.getCurrentAccount().amount);
    }
    @Test
    public void setCurrentAccountWithdrawTooMuch(){
        bank = new Bank("GDA");
        bank.setCurrentAccount(BigDecimal.valueOf(500));
        //Assertions.assertEquals(BigDecimal.valueOf(500),bank.getCurrentAccount().amount);
        assertThrows(IllegalArgumentException.class, () -> bank.setCurrentAccount(BigDecimal.valueOf(-700)));
    }

    @Test
    public void makeNewTransaction(){
        bank = new Bank("GDA");
        Bank bank1 = new Bank("WAR");
        bank.transactions.add(new Transaction(BigDecimal.valueOf(500), Transaction.accountType.DEBET));
        bank.setCurrentAccount(BigDecimal.valueOf(500));
        Assertions.assertEquals(bank.generateTransactionsSummary(),bank1.makeNewTransaction(BigDecimal.valueOf(500), Transaction.accountType.DEBET));

        bank.transactions.add(new Transaction(BigDecimal.valueOf(900), Transaction.accountType.CREDIT));
        bank.setSavingAccount(BigDecimal.valueOf(900));
       Assertions.assertEquals(bank.generateTransactionsSummary(),bank1.makeNewTransaction(BigDecimal.valueOf(900), Transaction.accountType.CREDIT));

        bank.transactions.add(new Transaction(BigDecimal.valueOf(-200), Transaction.accountType.DEBET));
        bank.setCurrentAccount(BigDecimal.valueOf(-200));
        Assertions.assertEquals(bank.generateTransactionsSummary(),bank1.makeNewTransaction(BigDecimal.valueOf(-200), Transaction.accountType.DEBET));

        Assertions.assertEquals(bank.getBalance(),bank1.getBalance());
    }


}
