package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankManagerTest {

    @Test
    public void testDecideRequest(){
        OverDraftRequest request = new OverDraftRequest(100, new CurrentAccount());
        BankManager manager = new BankManager();

        Assertions.assertEquals("request accepted", manager.decideRequest(request, true));
        Assertions.assertEquals("request rejected", manager.decideRequest(request, false));
    }
}