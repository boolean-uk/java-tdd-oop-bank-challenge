package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Customer customer;


    @BeforeEach
    public void setUp() {
        customer = new Customer("Marlena Luczak");
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
    public void testWithdrawFunds_withdrawLessThanItIsInAccount_shouldReturnEquals(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(30.5);
        currentAccount.depositFunds(12.0);
        currentAccount.withdrawFunds(12.0);
        Assertions.assertEquals(30.5, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds_withdrawMoreThanItIsInAccount_shouldThrowException(){
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(12.0);
        Assertions.assertThrows(RuntimeException.class, () -> currentAccount.withdrawFunds(13.0));
    }

}
