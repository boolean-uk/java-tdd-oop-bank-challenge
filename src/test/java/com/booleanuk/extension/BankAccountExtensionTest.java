package com.booleanuk.extension;

import com.booleanuk.core.BankAccount;
import com.booleanuk.core.BankAffiliate;
import com.booleanuk.core.BankBranch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankAccountExtensionTest {

    @Test
    public void testBalanceCalculation() { //Testing extension user story 1 method
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch, 1000,500.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        bankAffiliate.depositFunds(bankAccount, 100);
        bankAffiliate.withdrawFunds(bankAccount,50);
        Assertions.assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void testRequestOverdraft() { //Testing extension user story 3
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount account = new BankAccount("John Doe", "123456789", "Checking", branch, 1000.0, 500.0);

        // Request an overdraft limit of $1000
        boolean requestResult = account.requestOverdraft(1000.0);
        Assertions.assertTrue(requestResult);
        Assertions.assertEquals(1000.0, account.getOverdraftLimit());
    }

    @Test
    public void testApproveOverdraft() { //Testing extension user story 4

        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount account = new BankAccount("John Doe", "123456789", "Checking", branch, 1000.0, 500.0);
        BankAffiliate affiliate = new BankAffiliate("Jane Doe", "Branch Manager");

        // Attempt to approve an overdraft limit of $1000
        boolean approvalResult = affiliate.approveOverdraft(account, 1000.0);
        Assertions.assertTrue(approvalResult);
        Assertions.assertEquals(1000.0, account.getOverdraftLimit());
    }
}
