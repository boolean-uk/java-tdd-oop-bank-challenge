package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

public class BranchTest {

    private static Bank bank;

    @BeforeAll
    public static void globalSetup() {
        Locale locale = new Locale("el", "GR");
        BankManager bankManager = new BankManager();
        bank = new Bank("EuroBank", "100", locale, bankManager);
    }

    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Branch(null, "255", bank));
        Assertions.assertThrows(NullPointerException.class,
                () -> new Branch("Athens", "255", null));
    }

    @Test
    public void checkConstructor_BranchCodeFormat() {
        Assertions.assertDoesNotThrow(() -> new Branch("Athens", "2555", bank));
        Assertions.assertDoesNotThrow(() -> new Branch("Athens", " 5255  ", bank));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Branch("Athens", "-555", bank));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Branch("Athens", "+555", bank));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Branch("Athens", "22555", bank));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Branch("Athens", "555", bank));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Branch("Athens", "as55", bank));
    }

    @Test
    public void checkCreateCustomer_CustomerAlreadyExists() {
        Branch branch = new Branch("Athens", "2555", bank);

        Assertions.assertEquals(0, branch.getCustomers().size());

        // set up
        String tin = "GR123456789";
        String idCard = "AT12345";
        String name = "Dimitris";
        String surname = "Tsimaras";
        LocalDate dateOfBirth = LocalDate.parse("1992-04-04");

        branch.createCustomer(tin, idCard, name, surname, dateOfBirth);
        Assertions.assertEquals(1, branch.getCustomers().size());

        branch.createCustomer(tin, idCard, name, surname, dateOfBirth);
        Assertions.assertEquals(1, branch.getCustomers().size());

        branch.createCustomer(tin, "differentID", name, surname, dateOfBirth);
        Assertions.assertEquals(1, branch.getCustomers().size());

        branch.createCustomer("GR987654321", idCard, name, surname, dateOfBirth);
        Assertions.assertEquals(1, branch.getCustomers().size());
    }
}
