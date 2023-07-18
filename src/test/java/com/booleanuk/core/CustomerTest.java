package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CustomerTest {

    @Test
    void createCurrentAccount_ShouldCreateCurrentAccount(){
        Customer customer = new Customer();

        Assertions.assertDoesNotThrow(customer::createCurrentAccount);
    }

    @Test
    void createSavingsAccount_ShouldCreateSavingsAccount(){
        Customer customer = new Customer();

        Assertions.assertDoesNotThrow(customer::createSavingsAccount);
    }

    @Test
    void createSavingsAccount_ShouldNotCreateSavingsAccountBecauseExist(){
        Customer customer = new Customer();
        customer.createSavingsAccount();
        Assertions.assertThrows(IllegalStateException.class, customer::createSavingsAccount);
    }

    @Test
    void createCurrentAccount_ShouldNotCreateCurrentAccountBecauseExist(){
        Customer customer = new Customer();
        customer.createCurrentAccount();
        Assertions.assertThrows(IllegalStateException.class, customer::createCurrentAccount);
    }

    @Test
    void withDrawFromSavingsAccount_ShouldNotWithdrawFromCurrentAccountDoesNotExist(){
        Customer customer = new Customer();
        Assertions.assertThrows(IllegalStateException.class, () -> customer.withDrawFromSavingsAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void withDrawFromSavingsAccount_ShouldWithdrawFromCurrentAccount(){
        Customer customer = new Customer();
        customer.createSavingsAccount();
        customer.addBalanceToSavingsAccount(BigDecimal.valueOf(500));
        Assertions.assertDoesNotThrow(() -> customer.withDrawFromSavingsAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void withDrawFromCurrentAccount_ShouldNotWithdrawFromCurrentAccountDoesNotExist(){
        Customer customer = new Customer();
        Assertions.assertThrows(IllegalStateException.class, () -> customer.withDrawFromCurrentAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void withDrawFromCurrentAccount_ShouldWithdrawFromCurrentAccount(){
        Customer customer = new Customer();
        customer.createCurrentAccount();
        customer.addBalanceToCurrentAccount(BigDecimal.valueOf(500));
        Assertions.assertDoesNotThrow(() -> customer.withDrawFromCurrentAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void addBalanceToSavingsAccount_ShouldAddBalance(){
        Customer customer = new Customer();
        customer.createSavingsAccount();

        Assertions.assertDoesNotThrow(() -> customer.addBalanceToSavingsAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void addBalanceToCurrentAccount_ShouldAddBalance(){
        Customer customer = new Customer();
        customer.createCurrentAccount();

        Assertions.assertDoesNotThrow(() -> customer.addBalanceToCurrentAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void addBalanceToCurrentAccount_ShouldNotAddBalanceCurrentAccountNotExist(){
        Customer customer = new Customer();

        Assertions.assertThrows(IllegalStateException.class, () -> customer.addBalanceToCurrentAccount(BigDecimal.valueOf(500)));
    }

    @Test
    void addBalanceToSavingsAccount_ShouldNotAddBalanceCurrentAccountNotExist(){
        Customer customer = new Customer();

        Assertions.assertThrows(IllegalStateException.class, () -> customer.addBalanceToSavingsAccount(BigDecimal.valueOf(500)));
    }
}
