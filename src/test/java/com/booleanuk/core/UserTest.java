package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    @BeforeEach
    void setUp(){
        user = new User(286, "Thomas", "Oslo");
    }
    @Test
    public void testGetUserAttributes(){
        Assertions.assertEquals(286, user.getId());
        Assertions.assertEquals("Thomas", user.getName());
        Assertions.assertEquals("Oslo", user.getBranch());
    }
}
