package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank = new Bank();
    private User user = new User("1","A");
    private Account currAccount = new CurrentAccount(user,"1234", "current");
    private Account savAccount = new SaveAccount(user,"2345", "save");

    @Test
    public void createCurrentAccount(){
        Assertions.assertTrue(bank.createAccount(currAccount ));
        bank.createAccount( currAccount);
        Assertions.assertFalse(bank.createAccount( currAccount));
    }
    @Test
    public void createSaveAccount(){
        Assertions.assertTrue(bank.createAccount( savAccount));
        bank.createAccount( savAccount);
        Assertions.assertFalse(bank.createAccount( savAccount));
    }

    @Test
    public void testGenerateBankStatement() {
        currAccount.deposit(2000);
        currAccount.deposit(4000);

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String testStatement = "date      credit    debit     balance   \n" +
                date + "      2000.0   0.0      2000.0       \n" +
                date + "      4000.0   0.0      6000.0";

        Assertions.assertEquals(removeSpaces(testStatement), removeSpaces(currAccount.generateBankStatement()));
    }

    private String removeSpaces(String s) {
        return s.replaceAll("\\s", "");
    }

    @Test
    public void testComputeBalance(){
        bank.createAccount(currAccount);
        currAccount.deposit(1000);
        currAccount.withdraw(500);
        Assertions.assertEquals(500, currAccount.computeBalance());
        currAccount.withdraw(200);
        Assertions.assertEquals(300, currAccount.computeBalance());

    }
    @Test
    public void testGetBranch(){
        bank.createAccount(currAccount);
        Assertions.assertEquals(Branch.GOTHENBURG, currAccount.getBranch());
        bank.createAccount(savAccount);
        Assertions.assertEquals(Branch.GOTHENBURG, savAccount.getBranch());

    }

}