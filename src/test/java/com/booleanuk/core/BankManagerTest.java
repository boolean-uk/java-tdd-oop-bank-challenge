package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void init() {
        BankManager bankManager = new BankManager();

    }

    @Test
    public void approveOverdraft() {
        BankManager bankManager = new BankManager();

        Overdraft overdraft = new Overdraft(500);

        Assertions.assertFalse(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isApproved());
        Assertions.assertTrue(bankManager.approveOverdraft(overdraft));
        Assertions.assertTrue(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isLookedAt());
        Assertions.assertTrue(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isApproved());



    }

    @Test
    public void rejectOverdraft() {
        BankManager bankManager = new BankManager();

        Overdraft overdraft = new Overdraft(500);

        Assertions.assertFalse(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isApproved());
        Assertions.assertTrue(bankManager.rejectOverdraft(overdraft));
        Assertions.assertTrue(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isLookedAt());
        Assertions.assertFalse(bankManager.getOverdraftRequests().get(bankManager.getOverdraftRequests().indexOf(overdraft)).isApproved());

    }

    @Test
    public void addAndRemoveOverdraft() {
        BankManager bankManager = new BankManager();

        Overdraft overdraft = new Overdraft(500);

        Assertions.assertTrue(bankManager.addOverDraft(overdraft));
        Assertions.assertTrue(bankManager.getOverdraftRequests().contains(overdraft));
        Assertions.assertTrue(bankManager.removeOverdraft(overdraft));
        Assertions.assertFalse(bankManager.getOverdraftRequests().contains(overdraft));


    }


}
