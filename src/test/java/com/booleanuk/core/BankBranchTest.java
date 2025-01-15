package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankBranchTest {
    private ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>(){{
        BankAccount currentAccount = new CurrentAccount(1, 1000D);
        add(currentAccount);

        BankAccount savingsAccount = new SavingsAccount(2, 2000D);
        add(savingsAccount);
    }};


    @Test
    public void bankAccountIdExistsAlready(){
        BankBranch bankBranch = new BankBranch(1, "Gothenburg", listOfBankAccounts);
        BankAccount existingAccount = new CurrentAccount(1, 5000D);


        Assertions.assertFalse(bankBranch.addAccount(existingAccount));
    }

}
