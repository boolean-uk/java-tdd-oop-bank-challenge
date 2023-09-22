package com.booleanuk;

import com.booleanuk.core.Branch;
import com.booleanuk.core.MessageService;

public class CurrentAccount extends Account {

    public CurrentAccount(Branch branch, String customerPhoneNumber, MessageService messageService) {
        super(branch, customerPhoneNumber, messageService);
    }

}
