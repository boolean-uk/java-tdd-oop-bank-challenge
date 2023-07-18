package com.booleanuk.core;

import com.booleanuk.core.enums.BANK_NAMES;
import com.booleanuk.core.enums.OVERDRAFT_STATE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountExtensionTests {
        private static Customer customer;
        private static Bank bank;
        private static Branch branch;
        private static BankManager bankManager;

        @BeforeAll
        public static void setup() {
            bankManager = new BankManager("Jan", "Kowalski");
            bank = new Bank(BANK_NAMES.SANTANDER, bankManager);
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

        @Test
        public void requestOverdraftOnMyAccountShouldBePending(){
            Account current = new CurrentAccount(customer, branch);
            current.requestOverdraft(BigDecimal.valueOf(1000));
            Assertions.assertEquals(OVERDRAFT_STATE.PENDING,current.getOverdraftStatus());
        }

        @Test
        public void requestOverdraftOnMyAccountShouldBeRejected(){
            Account current = new CurrentAccount(customer, branch);
            current.requestOverdraft(BigDecimal.valueOf(1000));

            bankManager.processOverdraftRequest(current.getRequest(), OVERDRAFT_STATE.REJECTED);

            Assertions.assertEquals(OVERDRAFT_STATE.REJECTED,current.getOverdraftStatus());
        }

    @Test
    public void requestOverdraftOnMyAccountShouldBeApproved(){
        Account current = new CurrentAccount(customer, branch);
        current.requestOverdraft(BigDecimal.valueOf(1000));

        bankManager.processOverdraftRequest(current.getRequest(), OVERDRAFT_STATE.APPROVED);

        Assertions.assertEquals(OVERDRAFT_STATE.APPROVED,current.getOverdraftStatus());
        //should be able to withdraw
        current.withdraw(BigDecimal.valueOf(1000));
    }

    @Test
    public void shouldNotBeAbleToWithdrawMoreThanOverdraftAmount(){
        Account current = new CurrentAccount(customer, branch);
        current.requestOverdraft(BigDecimal.valueOf(1000));

        bankManager.processOverdraftRequest(current.getRequest(), OVERDRAFT_STATE.APPROVED);

        Assertions.assertEquals(OVERDRAFT_STATE.APPROVED,current.getOverdraftStatus());

        Assertions.assertThrows(IllegalStateException.class, () -> current.withdraw(BigDecimal.valueOf(2000)),
                "Expected an IllegalStateException to be thrown for insufficient funds");
    }

    }


