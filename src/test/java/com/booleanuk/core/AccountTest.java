package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.booleanuk.core.NumberUtils.*;


public class AccountTest {

    //Core requirements
    //
    @Test
    public void generateBankStatement(){
        Account account = new Account("Test", Branch.Oslo);
        account.deposit(100f);
        account.withdraw(30f);
        account.generateBankStatement();
        account.printBankStatement();

        //Remember to change date when testing
        String bankStatement =
                "[Date        ||     Amount ||     Balance, " +
                "----------------------------------------, " +
                "27/08/2024  ||    100.00£ ||     100.00£, " +
                "27/08/2024  ||    -30.00£ ||      70.00£]";

        Assertions.assertEquals(bankStatement,account.getBankStatement().toString());
    }

    @Test
    public void depositFunds(){
        Account account = new Account("Test", Branch.Bergen);
        account.deposit(100);
        Assertions.assertEquals(floatFormatter(100f), floatFormatter(centsToPounds(account.getBalanceInCents())));

    }

    @Test
    public void withdrawFunds(){
        Account account = new Account("Test", Branch.Trondheim);
        Assertions.assertEquals("Not enough funds.", account.withdraw(100));
        account.deposit(100);
        Assertions.assertEquals("Funds withdrawn from account.", account.withdraw(50));
        Assertions.assertEquals(floatFormatter(50f), floatFormatter(centsToPounds(account.getBalanceInCents())));
    }

    // Extension requirements
    //
    // User story 1: Account balance calculated on transaction history
    @Test
    public void calculateAccountBalance(){
        Account account = new Account("Test", Branch.Oslo);
        Assertions.assertEquals(0, account.getBalanceInCents());
        account.deposit(100);
        Assertions.assertEquals(floatFormatter(100f), floatFormatter(centsToPounds(account.getBalanceInCents())));
    }

    // User story 2: Accounts are associated with specific branches
    @Test
    public void isAccountAssociatedWithBranch(){
        Account account = new CurrentAccount("Test", Branch.Oslo);
        Assertions.assertEquals(Branch.Oslo, account.getBranch());
    }

}
