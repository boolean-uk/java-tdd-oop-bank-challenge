package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
     @Test
     public void testUserCreation() {
         User user = new User("0001", "John");
         Assertions.assertEquals("0001", user.getUserId());
         Assertions.assertEquals("John", user.getName());
     }

     @Test
     public void testGetAccountNumbers() {
         User user = new User("1", "John");
         user.addAccount(new SavingsAccount("1", "0000", "001"));
         user.addAccount(new CurrentAccount("1", "0000", "002"));
         ArrayList<String> accNums = user.getAccountNumbers();
         Assertions.assertEquals("001", accNums.getFirst());
         Assertions.assertEquals("002", accNums.getLast());
     }

     @Test
    public void testAddAccounts() {
         User user = new User("1", "John");
         ArrayList<String> accNums = user.getAccountNumbers();
         Assertions.assertTrue(accNums.isEmpty());
         user.addAccount(new SavingsAccount("1", "0000", "001"));
         accNums = user.getAccountNumbers();
         Assertions.assertEquals("001", accNums.getFirst());
         Assertions.assertEquals(1, user.getAccountNumbers().size());
     }

}