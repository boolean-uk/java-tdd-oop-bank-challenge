package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    private Manager manager;
    private CurrentAccount account;
    private User user;

    @BeforeEach
    void setUp(){
        manager = new Manager("Representative","Oslo");
        user = new User(3444, "Thomas","Oslo");
        account = new CurrentAccount(user);
    }

    @Test
    public void testSetOverdraftLimit(){
        manager.setMaximumOverdraft(300);
        Assertions.assertEquals(-300, manager.getMaximumOverdraft());
    }

    @Test
    public void testOverdraftRequestDenied(){
        account.setBalance(30);
        int overdraftRequest = 600;
        manager.setMaximumOverdraft(0);
        Assertions.assertEquals(false, account.requestOverdraft(overdraftRequest));
    }

    @Test
    public void testAcceptingOverdraftRequest(){
        account.setBalance(30);
        int overdraftRequest = 600;
        account.requestOverdraft(overdraftRequest);
        manager.setMaximumOverdraft(overdraftRequest);

        Assertions.assertEquals(true, account.requestAccepted(overdraftRequest));
    }

}
