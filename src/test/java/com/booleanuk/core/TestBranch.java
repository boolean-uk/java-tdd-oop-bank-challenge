package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class TestBranch {

    @BeforeEach
    public void resetCounter() throws NoSuchFieldException, IllegalAccessException {
        Field counterField = Branch.class.getDeclaredField("counter");
        counterField.setAccessible(true);
        counterField.set(null, 1000);
    }

    @Test
    public void testGetBranchID(){
        Branch branch1 = new Branch();
        Assertions.assertEquals(1000, branch1.getBranchID());
        Branch branch2 = new Branch();
        Assertions.assertEquals(1001, branch2.getBranchID());
        Branch branch3 = new Branch();
        Assertions.assertEquals(1002, branch3.getBranchID());
    }

    //Same for savings account
    @Test
    public void testCreateCurrentAccount(){
        Branch branch = new Branch();
        branch.createCurrentAccount();
        branch.createCurrentAccount();
        Assertions.assertEquals(1000100000, branch.getAccounts().get(100000).getAccountNumber());
        Assertions.assertEquals(1000100001, branch.getAccounts().get(100001).getAccountNumber());

        Branch branch1 = new Branch();
        branch1.createCurrentAccount();
        branch1.createCurrentAccount();
        Assertions.assertEquals(1001100000, branch1.getAccounts().get(100000).getAccountNumber());
        Assertions.assertEquals(1001100001, branch1.getAccounts().get(100001).getAccountNumber());
    }
}
