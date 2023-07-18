package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTest {
    @Test
    public void gettersAndSettersTest() {
        Request request1 = new Request();
        Request request2 = new Request();
        Request request3 = new Request();

        Assertions.assertEquals(1, request1.getId());
        Assertions.assertEquals(2, request2.getId());
        Assertions.assertEquals(3, request3.getId());

        Assertions.assertEquals(AcceptanceStatus.Pending, request1.getStatus());
        request1.setStatus(AcceptanceStatus.Declined);
        request2.setStatus(AcceptanceStatus.Accepted);
        Assertions.assertEquals(AcceptanceStatus.Declined, request1.getStatus());
        Assertions.assertEquals(AcceptanceStatus.Accepted, request2.getStatus());
        Assertions.assertEquals(AcceptanceStatus.Pending, request3.getStatus());
    }

}
