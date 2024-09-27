package com.booleanuk.core.extension;

import com.booleanuk.core.CurrentAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankBranchTest {
    @Test
    public void accountShouldHaveBankBranch() {
        //Setup
        CurrentAccount currentAccount = new CurrentAccount(BankBranch.PARIS1);

        //Verify
        Assertions.assertEquals(BankBranch.PARIS1, currentAccount.getBankBranch());
    }

}