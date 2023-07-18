package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.AccountType;
import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ManagerTest {

    @Test
    public void approveTest(){
        Manager manager = new Manager("Dave", "Ames", LocalDate.of(1990,01,01), "Manager");
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        Account account1 = new Account(AccountType.SAVING, customer, LocalDate.now(), 0);
        account.create();
        Assertions.assertEquals("Approved", manager.approve(account));
        Assertions.assertEquals("Rejected", manager.reject(account1));

    }
}
