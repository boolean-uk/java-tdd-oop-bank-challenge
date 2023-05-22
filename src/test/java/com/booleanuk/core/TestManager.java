package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManager {
    @Test
    public void testOverdraft(){
        Manager manager = new Manager(true);
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        Branch branch = new Branch(1);
        myself.setUpCurrentAccount(branch,new Balance(100,0));
        CurrentAccount temp = (CurrentAccount)myself.getAccounts().get(0);
        temp.requestOverdraft(manager);
        //now i can overdraft
        Assertions.assertTrue(temp.getCanOverdraft());
        System.out.println(temp.getBalanceByStatements());
        Assertions.assertTrue(temp.withdraw(new Balance(110,0)));
        System.out.println(temp.getBalanceByStatements());
        //can overdraft and now the balance is -10.
    }
}
