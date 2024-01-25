package com.booleanuk.extensions;

import com.booleanuk.extensions.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void checkOverdraftStatus() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        Assertions.assertEquals(false, account.getOverdraftStatus());

        account.requestOverdraft();

        bank.acceptOverdraftRequest(account);

        Assertions.assertEquals(true, account.getOverdraftStatus());
    }
}
