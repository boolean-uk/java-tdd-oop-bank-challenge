package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
     @Test
     public void testUserCreation() {
         User user = new User("0001", "John");
         Assertions.assertEquals("0001", user.getUserId());
         Assertions.assertEquals("John", user.getName());
     }

}