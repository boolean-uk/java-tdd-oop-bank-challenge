package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankBranchTest {
    private ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>(){{
        BankAccount currentAccount = new CurrentAccount(1, 1);
        add(currentAccount);

        BankAccount savingsAccount = new SavingsAccount(2, 1);
        add(savingsAccount);
    }};


    @Test
    public void bankAccountIdExistsAlready(){
        BankBranch bankBranch = new BankBranch(1, "Gothenburg", listOfBankAccounts);
        BankAccount existingAccount = new CurrentAccount(1, 1);

        Assertions.assertFalse(bankBranch.addAccount(existingAccount));
    }

    @Test
    public void bankAccountIdDontExists(){
        BankBranch bankBranch = new BankBranch(1, "Gothenburg", listOfBankAccounts);
        BankAccount newAccount = new CurrentAccount(3, 1);

        Assertions.assertTrue(bankBranch.addAccount(newAccount));
    }




    // EXTENSION 2
    @Test
    public void bankAccountIsIncludedInBankBranchListOfBankAccounts(){
        BankBranch bankBranch = new BankBranch(1, "Gothenburg", listOfBankAccounts);
        BankAccount newAccount = new CurrentAccount(3, 1);
        bankBranch.addAccount(newAccount);

        Assertions.assertTrue(bankBranch.belongsBankAccountToBankBranch(newAccount));
    }

    @Test
    public void bankAccountIsNotIncludedInBankBranchListOfBankAccounts(){
        BankBranch bankBranch = new BankBranch(1, "Gothenburg", listOfBankAccounts);
        BankAccount newAccount = new CurrentAccount(3, 1);

        Assertions.assertFalse(bankBranch.belongsBankAccountToBankBranch(newAccount));
    }


}
