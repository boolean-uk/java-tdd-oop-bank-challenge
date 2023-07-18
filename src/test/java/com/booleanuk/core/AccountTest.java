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
        customer.createAccount("saving");
        Assertions.assertEquals(1, customer.getAccounts().size());
    }
    @Test
    public void testCreateAccount_afterAddingTwoAccount_shouldReturnNotEqual() {
        customer.createAccount("saving");
        customer.createAccount("current");
        Assertions.assertNotEquals(1, customer.getAccounts().size());
    }

    @Test void testCreateAccount_wrongTypeOfArgument_shouldThrowException(){
        Assertions.assertThrows(RuntimeException.class, () -> customer.createAccount("different"));
    }
}
