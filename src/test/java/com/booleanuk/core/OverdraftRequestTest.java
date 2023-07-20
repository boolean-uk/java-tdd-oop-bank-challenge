package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverdraftRequestTest {
    @Test
    public void testOverdraftRequestAndApproval() {
        //As a customer,
        //So I have an emergency fund,
        //I want to be able to request an overdraft on my account.
        String accountNumber = "123456789";
        double amount = 1000.0;
        OverdraftRequest overdraftRequest = new OverdraftRequest("1", accountNumber, amount);

        assertEquals("pending", overdraftRequest.getStatus());
        overdraftRequest.updateStatus("approved");

        //As a bank manager,
        //So I can safeguard our funds,
        //I want to approve or reject overdraft requests.
        assertEquals("approved", overdraftRequest.getStatus());
    }
}
