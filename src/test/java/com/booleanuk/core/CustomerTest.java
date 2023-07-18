package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerTest {

    Customer customer;


    @BeforeEach
    public void setUp() {
        customer = new Customer("Marlena Luczak");
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
    public void testGenerateBankStatement_usingToStringMethodForFirstElementOfTransactions_ShouldReturnEqual(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(45.78);
        Assertions.assertEquals(LocalDate.now() + " || 45.78   ||         || 45.78", customer.getAllAccounts().get(0).getTransactions().get(0).toString());
    }
    @Test
    public void testGenerateBankStatement_usingToStringMethodForSecondElementOfTransactions_ShouldReturnEqual1(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(45.78);
        currentAccount.withdrawFunds(5);
        Assertions.assertEquals(LocalDate.now() + " ||        || 5.0    || 40.78", customer.getAllAccounts().get(0).getTransactions().get(1).toString());
    }
}
