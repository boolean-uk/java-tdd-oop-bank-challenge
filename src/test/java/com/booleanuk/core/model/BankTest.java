package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class BankTest {

    private static Locale locale;
    private static BankManager bankManager;
    @BeforeAll
    public static void globalSetup() {
        locale = new Locale("el", "GR");
        bankManager = new BankManager();
    }
    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Bank(null, "255", locale, bankManager));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Bank("Alpha Bank", "255", null, bankManager));
    }

    @Test
    public void checkConstructor_BankCodeFormat() {
        Assertions.assertDoesNotThrow(() -> new Bank("EuroBank", "255", locale, bankManager));
        Assertions.assertDoesNotThrow(() -> new Bank("EuroBank", " 255  ", locale, bankManager));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bank("EuroBank", "-55", locale, bankManager));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bank("EuroBank", "+55", locale, bankManager));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bank("EuroBank", "2255", locale, bankManager));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bank("EuroBank", "55", locale, bankManager));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bank("EuroBank", "as55", locale, bankManager));
    }

    @Test
    public void checkAddBranch_BranchAlreadyExists() {
        Bank bank = new Bank("EuroBank", "255", locale, bankManager);
        String branchName = "Athens";
        String branchCode = "1010";
        Assertions.assertEquals(0, bank.getBranches().size());

        bank.createBranch(branchName, branchCode);
        Assertions.assertEquals(1, bank.getBranches().size());

        bank.createBranch(branchName, branchCode);
        Assertions.assertEquals(1, bank.getBranches().size());

        bank.createBranch(branchName, "1500");
        Assertions.assertEquals(1, bank.getBranches().size());

        bank.createBranch("Arta", branchCode);
        Assertions.assertEquals(1, bank.getBranches().size());
    }
}
