package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void initCurrentAccount() {

        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

    }

    @Test
    public void withdrawMoreThanNullWithOverdraft() {

        Customer customer = new Customer();

        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        customer.createAccount(currentAccount);

        Overdraft overdraft = new Overdraft(500);



    }

}
