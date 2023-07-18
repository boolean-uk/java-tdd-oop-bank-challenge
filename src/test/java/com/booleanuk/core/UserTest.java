package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void gettersTest() {
        User user = new User("John", "Doe");
        Assertions.assertEquals("John", user.getFirstName());
        Assertions.assertEquals("Doe", user.getLastName());
    }
    @Test
    public void createAccountTest() {
        User user = new User("John", "Doe");
        Assertions.assertTrue(user.createNewAccount("savings", 1000.0, "saving1"));
        Assertions.assertTrue(user.createNewAccount("savings", 1000.0, "saving2"));
        Assertions.assertTrue(user.createNewAccount("current", 1000.0, "current1"));
        Assertions.assertTrue(user.createNewAccount("current", 1000.0, "current2"));
        Assertions.assertFalse(user.createNewAccount("savings", 1000.0, "saving1"));
        Assertions.assertFalse(user.createNewAccount("checking", 1000.0, "checking1"));
    }
    @Test
    public void getAccountByIdTest() {
        User user = new User("John", "Doe");
        user.createNewAccount("savings", 1000.0, "saving1");
        user.createNewAccount("savings", 2000.0, "saving2");
        Assertions.assertEquals(1000.0, user.getAccountById("saving1").getBalance());
        Assertions.assertEquals(2000.0, user.getAccountById("saving2").getBalance());
    }
}
