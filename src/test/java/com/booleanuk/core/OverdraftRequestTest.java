package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftRequestTest {

    @Test
    public void checkRequestWhenAmountIsOverLimit(){
        OverDraftRequest overDraftRequest = new OverdraftRequest();
        Assertions.assertTrue(overDraftRequest.CheckRequest(500, 0));
    }

    @Test
    public void checkRequestWhenAmountIsUnderLimit(){
        OverDraftRequest overDraftRequest = new OverdraftRequest();
        Assertions.assertFalse(overDraftRequest.CheckRequest(5000, 0));
    }
}
