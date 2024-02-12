package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BankStatementTest {

    @Test
    public void generateBankStatementTest() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer");
        BankAccount bankAccount = new BankAccount("James Bond", "12345", "Current Account", branch, 1000.00, 1000);
        BankStatement bankStatement = new BankStatement();

        // Perform transactions
        bankAffiliate.depositFunds(bankAccount, 250);
        bankAffiliate.depositFunds(bankAccount, 250);
        bankAffiliate.withdrawFunds(bankAccount, 100);
        bankAffiliate.withdrawFunds(bankAccount, 50);

        String actualBankStatement = bankStatement.generateBankStatement(bankAffiliate, bankAccount);

        LocalDate formattedDate = LocalDate.now();

        String expectedBankStatement = "\nDate       || Deposit  || Withdrawal || Balance\n" +
                "2024-02-12 || 250.00   ||            || 1250.00\n" +
                "2024-02-12 || 250.00   ||            || 1500.00\n" +
                "2024-02-12 ||          || 100.00     || 1400.00\n" +
                "2024-02-12 ||          || 50.00      || 1350.00\n";



        Assertions.assertEquals(expectedBankStatement, actualBankStatement);

        //System.out.println(actualBankStatement);
    }
}
