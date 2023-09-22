package com.booleanuk;

import com.booleanuk.core.Branch;
import com.booleanuk.core.MessageService;

public class SavingAccount extends Account {
    public SavingAccount(Branch branch, String customerPhoneNumber, MessageService messageService) {
        super(branch, customerPhoneNumber, messageService);
    }
}
