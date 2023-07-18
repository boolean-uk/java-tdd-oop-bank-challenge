package com.booleanuk.core;

import com.booleanuk.core.enums.BANK_NAMES;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountExtensionTests {
        private static Customer customer;
        private static Bank bank;
        private static Branch branch;

        @BeforeAll
        public static void setup() {
            bank = new Bank(BANK_NAMES.SANTANDER);
            branch = new Branch("PLWAW01", "Poland", "Warsaw");
            bank.addBranch(branch);
            customer = new Customer("John", "Doe", LocalDate.parse("1990-01-01"));
            branch.addCustomer(customer);
        }

        @Test
        public void shouldOpenCurrentAccountWith0Balance() {
            Account current = new CurrentAccount(customer, branch);
            Assertions.assertEquals(BigDecimal.ZERO,current.getBalance());
        }

        @Test
        public void accountShouldBeAssociatedWithSpecificBranch(){
            Account current = new CurrentAccount(customer, branch);
            Assertions.assertEquals("PLWAW01",current.getBranch().getBranchCode());
        }

    }


