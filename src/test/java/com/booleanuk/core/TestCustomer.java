package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCustomer {
    @Test
    public void testConstructor(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        Assertions.assertEquals("Dennis Voutos",myself.getName());
        Assertions.assertEquals("Athens Greece",myself.getAddress());
        Assertions.assertEquals("26/03/1998",myself.getDateOfBirth());
        Assertions.assertEquals(12345,myself.getTaxpayerIdentificationNumber());
    }
    //these tests will change because of the changes of our project
    @Test
    public void testSetUpAccount(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        Branch branch = new Branch(1);
        myself.setUpSavingsAccount(1,0,branch);
        Assertions.assertEquals(0,myself.getAccounts().size());
        System.out.println(branch.getAccounts().get(0));//it exists
        //As a design choice, i don't want accounts with null balance for a user. so i made a function to remove all these accounts.
    }
    //these tests can also be done in the TestAccount class but since all of these things want to be done by the user, i decided to do them here.
    @Test
    public void testStatements(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        Branch branch = new Branch(2);
        myself.setUpCurrentAccount(branch,new Balance(100,0));
        myself.setUpSavingsAccount(branch,new Balance(50,0));
        System.out.println(myself.getAccounts().get(0).getBalanceByStatements());
        myself.getAccounts().get(0).withdraw(new Balance(30,0));
        System.out.println(myself.getAccounts().get(0).getBalanceByStatements());
        myself.getAccounts().get(0).withdraw(new Balance(20,0));
        System.out.println(myself.getAccounts().get(0).getBalanceByStatements());
        myself.getAccounts().get(0).deposit(new Balance(20,0));
        System.out.println(myself.getAccounts().get(0).getBalanceByStatements());
        //deposit $10 then 20 in the first account
        myself.getAccounts().get(1).deposit(new Balance(20,0));
        //deposited $20 in the second account
        myself.getAccounts().get(0).showStatements();
//        myself.getAccounts().get(0).getBalanceByStatements();
//        System.out.println(myself.getAccounts().get(0).getBalanceByStatements()); // works as i want it
        //i want to see the 20 first then the 10.
    }
}
