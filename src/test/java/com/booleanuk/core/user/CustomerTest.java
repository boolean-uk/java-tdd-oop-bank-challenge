package com.booleanuk.core.user;

import com.booleanuk.core.exception.BankAccountAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CustomerTest {
    @Test
    public void shouldCreateCustomerWithSpecifiedData() {
        Customer customer = new Customer();

        Assertions.assertNull(customer.getCurrentAccount());
        Assertions.assertNull(customer.getSavingAccount());
    }

    @Test
    public void shouldOpenCurrentAccount() {
        Customer customer = new Customer();
        Boolean result = customer.openCurrentAccount();

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldThrowAccountAlreadyExistsExceptionWhenTryingToRecreateCurrentAccount() {
        Customer customer = new Customer();
        customer.openCurrentAccount();

        BankAccountAlreadyExistsException bankAccountAlreadyExistsException = Assertions.assertThrows(BankAccountAlreadyExistsException.class, customer::openCurrentAccount);
        Assertions.assertEquals("You have opened Current Account with ID: " + customer.getCurrentAccount().getUuid(), bankAccountAlreadyExistsException.getMessage());
    }

    @Test
    public void shouldOpenSavingAccount() {
        Customer customer = new Customer();
        Boolean result = customer.openSavingAccount();

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldThrowAccountAlreadyExistsExceptionWhenTryingToRecreateSavingAccount() {
        Customer customer = new Customer();
        customer.openSavingAccount();

        BankAccountAlreadyExistsException bankAccountAlreadyExistsException = Assertions.assertThrows(BankAccountAlreadyExistsException.class, customer::openSavingAccount);
        Assertions.assertEquals("You have opened Saving Account with ID: " + customer.getSavingAccount().getUuid(), bankAccountAlreadyExistsException.getMessage());
    }

    @Test
    public void shouldBeAbleToGenerateCurrentAccountStatement() {
        Customer customer = new Customer();
        customer.openCurrentAccount();
        customer.depositCurrentAccount(BigDecimal.valueOf(1000));
        customer.depositCurrentAccount(BigDecimal.valueOf(2000));

        String result = customer.generateCurrentAccountStatements();

        Assertions.assertFalse(result.isBlank());
    }

    @Test
    public void shouldBeAbleToGenerateSavingAccountStatement() {
        Customer customer = new Customer();
        customer.openSavingAccount();
        customer.depositSavingAccount(BigDecimal.valueOf(1000));

        String result = customer.generateSavingAccountStatements();
        System.out.println(result);

        Assertions.assertFalse(result.isBlank());
    }
}
