package com.booleanuk.extension;

import com.booleanuk.extension.CurrentAccount;
import com.booleanuk.extension.Customer;
import com.booleanuk.extension.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Customer customer;
    BankManager bankManager;


    @BeforeEach
    public void setUp() {
        customer = new Customer("Marlena Luczak");
        bankManager = new BankManager("Anna Nowak");
    }

    @Test
    public void testChangeStatusOfOverDraftRequest_requestAccepted_ShouldReturnTrue(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        Assertions.assertTrue(bankManager.changeStatusOfOverDraftRequest(customer, currentAccount.getAccountNumber()));
    }
    @Test
    public void testChangeStatusOfOverDraftRequest_defaultValue_ShouldReturnFalse(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        Assertions.assertFalse(currentAccount.isOverdraft());
    }
    @Test
    public void testWithdrawFunds_overdraftAllowed_ShouldReturnEquals(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        bankManager.changeStatusOfOverDraftRequest(customer, currentAccount.getAccountNumber());
        currentAccount.depositFunds(12.0);
        currentAccount.withdrawFunds(100);
        Assertions.assertEquals(-88, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds_overdraftAllowed_ShouldReturnNotEquals(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(20.0);
        bankManager.changeStatusOfOverDraftRequest(customer, currentAccount.getAccountNumber());
        currentAccount.withdrawFunds(500);
        Assertions.assertNotEquals(-300, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds_overdraftAllowed_ShouldThrowException(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        bankManager.changeStatusOfOverDraftRequest(customer, currentAccount.getAccountNumber());
        Assertions.assertThrows(RuntimeException.class, () -> currentAccount.withdrawFunds(501));
    }

}
