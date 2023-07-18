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
    public void testDepositFunds(){
       SavingAccount savingAccount = customer.createSavingAccount();
       savingAccount.depositFunds(30.0);
       Assertions.assertEquals(30.0, savingAccount.getBalance());
    }

    @Test
    public void testDepositFunds(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(45.78);
        currentAccount.depositFunds(45.00);
        Assertions.assertEquals(90.78, currentAccount.getBalance());
    }

}
