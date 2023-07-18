package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Customer customer;
    Customer secondCustomer;


    @BeforeEach
    public void setUp() {
        customer = new Customer("Marlena Luczak");
        secondCustomer = new Customer("Anna Nowak");
    }
    @Test
    public void testCreateAccount_afterAddingOneAccount_shouldReturnEquals() {
        customer.createSavingAccount();
        Assertions.assertEquals(1, customer.getAllAccounts().size());
    }
    @Test
    public void testCreateAccount_afterAddingTwoAccount_shouldReturnNotEqual() {
        customer.createCurrentAccount();
        customer.createSavingAccount();
        Assertions.assertNotEquals(1, customer.getAllAccounts().size());
    }

    @Test
    public void testGetParticularTypeOfAccounts_wrongTypeOfArgument_shouldThrowException(){
        Assertions.assertThrows(RuntimeException.class, () -> customer.getAccountsByType("different"));
    }

    @Test
    public void testGetParticularTypeOfAccounts_rightTypeOfArgument_shouldNotThrowException(){
        Assertions.assertDoesNotThrow(() -> customer.getAccountsByType("saving"));
    }

    @Test
    public void testDepositFunds_afterPassing30ToMethod_ShouldReturnEquals(){
       SavingAccount savingAccount = customer.createSavingAccount();
       savingAccount.depositFunds(30.0);
       Assertions.assertEquals(30.0, savingAccount.getBalance());
    }

    @Test
    public void testDepositFunds_afterCallingMethodTwiceWithDifferentAmount_ShouldReturnEquals(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(45.78);
        currentAccount.depositFunds(45.00);
        Assertions.assertEquals(90.78, currentAccount.getBalance());
    }
    @Test
    public void testDepositFunds_newCreatedAccount_ShouldReturnNotEqual(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        Assertions.assertNotEquals(9.0, currentAccount.getBalance());
    }

    @Test
    public void testDepositFunds_addingNegativeNum_ShouldThrowException(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        Assertions.assertThrows(RuntimeException.class, () -> currentAccount.depositFunds(- 10.0));
    }

    @Test
    public void testWithdrawFunds_withdrawLessThanItIsOnAccount_shouldReturnEquals(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(30.5);
        currentAccount.depositFunds(12.0);
        currentAccount.withdrawFunds(12.0);
        Assertions.assertEquals(30.5, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds_withdrawMoreThanItIsOnAccount_shouldThrowException(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(12.0);
        Assertions.assertThrows(RuntimeException.class, () -> currentAccount.withdrawFunds(13.0));
    }

}
