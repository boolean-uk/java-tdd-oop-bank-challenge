package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OverDraftRequestTest {

    @Test
    public void testAcceptRequest(){
        OverDraftRequest request = new OverDraftRequest(100, new CurrentAccount());

        Assertions.assertTrue(request.isPending());
        Assertions.assertFalse(request.isAccepted());

        Assertions.assertEquals("request accepted", request.acceptRequest());

        Assertions.assertFalse(request.isPending());
        Assertions.assertTrue(request.isAccepted());

    }
    @Test
    public void testDeclineRequest(){
        OverDraftRequest request = new OverDraftRequest(100, new CurrentAccount());

        Assertions.assertTrue(request.isPending());
        Assertions.assertFalse(request.isAccepted());

        Assertions.assertEquals("request rejected", request.declineRequest());

        Assertions.assertFalse(request.isPending());
        Assertions.assertFalse(request.isAccepted());
    }
}