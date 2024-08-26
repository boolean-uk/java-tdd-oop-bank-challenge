package com.booleanuk.core;

import com.booleanuk.core.bank.Account;
import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.CurrentAccount;
import com.booleanuk.core.bank.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftTest {

    private Bank bank;
    private final Account.Branch DEFAULT_BRANCH = Account.Branch.GOTHENBURG;

    public OverdraftTest() {
        this.bank = new Bank("Nordea");
    }

    @Test
    public void testCreateOverdraft() {
        Customer max = this.bank.addCustomer(new Customer());
        Account maxAccount = this.bank.newAccount(max, new CurrentAccount(DEFAULT_BRANCH));

        this.bank.requestOverdraft(max, maxAccount, 1000);

        // Only one overdraft request in customer Max's current account, so getFirst() is ok
        Assertions.assertTrue(maxAccount.getOverdrafts(maxAccount).getFirst().getStatus() == Overdraft.OverdraftStatus.PENDING);
    }

}
