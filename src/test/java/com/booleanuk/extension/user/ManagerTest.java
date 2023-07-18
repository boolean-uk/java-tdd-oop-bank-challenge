package com.booleanuk.extension.user;

import com.booleanuk.core.banking.BankBranch;
import com.booleanuk.core.user.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void shouldCreateManagerWithBankBranch() {
        Manager manager = new Manager(BankBranch.POLAND_WARSAW_1);

        Assertions.assertEquals(BankBranch.POLAND_WARSAW_1, manager.getBankBranch());
    }
}
