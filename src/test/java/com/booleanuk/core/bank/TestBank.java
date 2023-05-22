package com.booleanuk.core.bank;

import com.booleanuk.core.account.BankAccount;
import com.booleanuk.core.account.CurrentBankAccount;
import com.booleanuk.core.account.SavingsBankAccount;
import com.booleanuk.core.statement.Statements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBank {
    @Test
    public void test() {
        BankAccount ba1 = new SavingsBankAccount(100, new Statements());
        BankAccount ba2 = new CurrentBankAccount(100, new Statements());
        BankAccount ba3 = new SavingsBankAccount(100, new Statements());
        BankAccount ba4 = new CurrentBankAccount(100, new Statements());

        Bank bank = new BasicBank("Athens", 1000);
        bank.add(ba1);
        bank.add(ba2);

        Bank bank2 = new BasicBank("London", 2000);
        bank2.add(ba3);
        bank2.add(ba4);

        // test add
        Assertions.assertEquals("Athens", ba1.branch().location());
        Assertions.assertEquals("Athens", ba2.branch().location());
        Assertions.assertEquals("London", ba3.branch().location());
        Assertions.assertEquals("London", ba4.branch().location());

        // test location
        Assertions.assertEquals("Athens", bank.location());
        Assertions.assertEquals("London", bank2.location());

        // test requestOverdraft
        // false, max limit is 1000
        Assertions.assertFalse(bank.requestOverdraft(ba1, 10000));
        // savings bank account doesnt deserve overdraft
        Assertions.assertFalse(bank.requestOverdraft(ba1, 1));
        // true, you can request up to including the limit
        Assertions.assertTrue(bank2.requestOverdraft(ba2, 2000));
    }
}
