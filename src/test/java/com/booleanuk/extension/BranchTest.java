package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.AccountType;
import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BranchTest {
    @Test
    public void associateTest(){
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        account.create();
        Branch warsaw = new Branch("Warsaw");
        Assertions.assertEquals("Associated to the branch located in Warsaw", warsaw.associate(account));
    }
}
