package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void shouldNotAddAccountAndThrowExceptionIfAccountAlreadyExists(){
        Bank bank = new Bank("AlphaBank");
        Branch branch = bank.createBranch("Athens");

        String customerId = branch.createCustomer();

        String accountId = branch.createAccount(customerId, Bank.AccountType.SAVINGS, 10000);
        Customer customer = branch.getCustomers().get(customerId);

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> customer.addAccount(customer.getAccounts().get(accountId)));

        Assertions.assertEquals(Bank.ErrorType.ACCOUNT_EXISTS.value, thrown.getMessage());
    }
}
