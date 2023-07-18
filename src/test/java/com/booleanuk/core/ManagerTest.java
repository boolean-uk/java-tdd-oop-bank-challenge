package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void shouldCreateMangerWithGivenName(){
        Manager manager = new Manager("123");
        Assertions.assertEquals("123",manager.getFullName());
    }
    @Test
    public void shouldManagerAcceptTheRequest(){
        Manager manager = new Manager("123");
        NormalAccount normalAccount = new NormalAccount(123123,"Warsaw");
      Assertions.assertTrue(  manager.ApproveOverdraftRequest(normalAccount,100));
    }

    @Test
    public void shouldntManagerAcceptTheRequest(){
        Manager manager = new Manager("123");
        NormalAccount normalAccount = new NormalAccount(123123,"Warsaw");
        Assertions.assertFalse(  manager.ApproveOverdraftRequest(normalAccount,700));
    }
}
