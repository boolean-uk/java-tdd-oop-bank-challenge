package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineerTest {

    @Test
    public void shouldCreateEngineerWithGivenName()
    {
        String name = "name";
        Engineer engineer = new Engineer(name);
        Assertions.assertEquals(name, engineer.getFullname());
    }

    @Test
    public void ShouldCalculateBankAccountProperly3000()
    {
        String name = "name";
        Engineer engineer = new Engineer(name);
        NormalAccount normalAccount = new NormalAccount(123123);
        normalAccount.deposit(2000);
        normalAccount.deposit(2000);
        normalAccount.withdraw(1000);
        Assertions.assertEquals(3000,engineer.getAccountBalance(normalAccount));
    }
    @Test
    public void ShouldCalculateBankAccountProperly2500()
    {
        String name = "name";
        Engineer engineer = new Engineer(name);
        NormalAccount normalAccount = new NormalAccount(123123);
        normalAccount.deposit(2000);
        normalAccount.deposit(2000);
        normalAccount.withdraw(1000);
        normalAccount.withdraw(500);
        Assertions.assertEquals(2500,engineer.getAccountBalance(normalAccount));
    }
    @Test
    public void ShouldCalculateBankAccountProperly3500()
    {
        String name = "name";
        Engineer engineer = new Engineer(name);
        NormalAccount normalAccount = new NormalAccount(123123);
        normalAccount.deposit(2000);
        normalAccount.deposit(2500);
        normalAccount.withdraw(1000);
        normalAccount.withdraw(-500);
        Assertions.assertEquals(3500,engineer.getAccountBalance(normalAccount));
    }
}
