package com.booleanuk.core;

import com.booleanuk.CurrentAccount;
import com.booleanuk.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private CurrentAccount currentAccount;
    private Branch branch;
    private MessageService messageService;

    @BeforeEach
    public void setUp() {
        messageService = new MessageService();
        branch = new Branch("123", "branch1", "+30 21025023456", "Stadiou 12");
        currentAccount = new CurrentAccount(branch, "6999787987", messageService);
    }

    @Test
    public void testCreateCurrentAccount() {

        Assertions.assertEquals(0.0, currentAccount.getCurrentBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }

    @Test
    public void testCreateSavingAccount() {
        SavingAccount currentAccount = new SavingAccount(branch,"6999787987", messageService);

        Assertions.assertEquals(0.0, currentAccount.getCurrentBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }

    @Test
    public void testDeposit() {
        currentAccount.deposit(25.30);
        Assertions.assertEquals(25.3, currentAccount.getCurrentBalance());
        currentAccount.generateBankStatement();
    }

    @Test
    public void testDepositInvalidAmount() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                currentAccount.deposit(-5));
        Assertions.assertTrue(exception.getMessage().contains("Please insert a positive number"));
        Assertions.assertEquals(0, currentAccount.getCurrentBalance());
    }

    @Test
    public void testWithdraw() {
        currentAccount.deposit(50);
        currentAccount.withdraw(25.5);
        Assertions.assertEquals(24.5, currentAccount.getCurrentBalance());
        currentAccount.generateBankStatement();
    }

    @Test
    public void testWithdrawInvalidNumber() {
        currentAccount.deposit(50);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                currentAccount.withdraw(51.5));
        Assertions.assertTrue(exception.getMessage().contains("Insufficient funds. This transaction cannot be completed"));
        Assertions.assertEquals(50, currentAccount.getCurrentBalance());
        currentAccount.generateBankStatement();
    }

    @Test
    public void testBranch() {
        Branch branch1 = new Branch("12a", "branch2", "+3021032944052", "Omirou 12");
        CurrentAccount currentAccount1 = new CurrentAccount(branch1, "6999787127", messageService);

        Assertions.assertEquals("branch2", currentAccount1.getBranch().getName());
        Assertions.assertEquals("branch1", currentAccount.getBranch().getName());
    }

    @Test
    public void testOverdraftRequest() {
        currentAccount.deposit(100);

        Assertions.assertTrue(currentAccount.requestAnOverdraftAndWithdraw(200));
        Assertions.assertEquals(-100, currentAccount.getCurrentBalance());

        Assertions.assertTrue(currentAccount.requestAnOverdraftAndWithdraw(50));
        Assertions.assertEquals(-150, currentAccount.getCurrentBalance());

        Assertions.assertFalse(currentAccount.requestAnOverdraftAndWithdraw(200));
        Assertions.assertEquals(-150, currentAccount.getCurrentBalance());
    }
}
