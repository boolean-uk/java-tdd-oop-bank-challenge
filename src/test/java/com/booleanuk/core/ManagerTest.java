package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    void overdraftRequestShouldSucceed() {
        Account account = Account.create("Test Branch");
        int requestsBefore = Manager.overdraftRequests.size();
        Manager.overdraftRequest(account);
        int requestsAfter = Manager.overdraftRequests.size();

        Assertions.assertEquals(requestsAfter, requestsBefore + 1);
    }

    @Test
    void acceptRequestShouldSucceed() {
        Account account = Account.create("Test Branch");
        Manager.overdraftRequest(account);

        Assertions.assertFalse(account.overdraft);

        Manager.acceptRequest(account, true);

        Assertions.assertTrue(account.overdraft);
    }
}
