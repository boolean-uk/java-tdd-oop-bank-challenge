package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.ACCOUNT_TYPE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class CustomerTest {

    private static Branch branch;
    private static String tin = "GR123456789";
    private static String idCard = "AT12345";
    private static String name = "Dimitris";
    private static  String surname = "Tsimaras";
    private static LocalDate dateOfBirth = LocalDate.parse("1992-04-04");
    @BeforeAll
    public static void globalSetup() {
        BankManager bankManager = new BankManager();
        Locale locale = new Locale("el", "GR");
        Bank bank = new Bank("EuroBank", "100", locale, bankManager);
        branch = new Branch("Athens", "2555", bank);
    }

    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Customer(tin, idCard, name, surname, null, branch));
        Assertions.assertThrows(NullPointerException.class,
                () -> new Customer(tin, idCard, null, surname, dateOfBirth, branch));
    }
    @Test
    public void checkConstructor_TINFormat() {
        Assertions.assertDoesNotThrow( () -> new Customer(tin, idCard, name, surname, dateOfBirth, branch));
        Assertions.assertDoesNotThrow( () -> new Customer(tin+"  ", idCard, name, surname, dateOfBirth, branch));
        Assertions.assertDoesNotThrow( () -> new Customer("as123456789", idCard, name, surname, dateOfBirth, branch));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer("asdsa456789", idCard, name, surname, dateOfBirth, branch));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer("12123456789", idCard, name, surname, dateOfBirth, branch));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer("GB6789", idCard, name, surname, dateOfBirth, branch));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer("UK1234567890", idCard, name, surname, dateOfBirth, branch));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer("UK01234567890", idCard, name, surname, dateOfBirth, branch));
    }

    @Test
    public void checkCreateAccount_Current() {
        Customer customer = new Customer(tin, idCard, name, surname, dateOfBirth, branch);

        Assertions.assertEquals(0,customer.getAccounts().size());

        customer.createAccount(ACCOUNT_TYPE.CURRENT);
        customer.createAccount(ACCOUNT_TYPE.CURRENT, new BigDecimal("500"));
        Assertions.assertEquals(2, customer.getAccounts().size());
    }

    @Test
    public void checkCreateAccount_Savings() {
        Customer customer = new Customer(tin, idCard, name, surname, dateOfBirth, branch);

        Assertions.assertEquals(0,customer.getAccounts().size());

        customer.createAccount(ACCOUNT_TYPE.SAVINGS);
        customer.createAccount(ACCOUNT_TYPE.SAVINGS, new BigDecimal("500"));
        Assertions.assertEquals(2, customer.getAccounts().size());
    }

    @Test
    public void checkCreateAccount_NullValues() {
        Customer customer = new Customer(tin, idCard, name, surname, dateOfBirth, branch);

        Assertions.assertEquals(0,customer.getAccounts().size());

        Assertions.assertThrows(NullPointerException.class,
                () -> customer.createAccount(null));
        Assertions.assertThrows(NullPointerException.class,
                () -> customer.createAccount(ACCOUNT_TYPE.SAVINGS, null));

        Assertions.assertEquals(0, customer.getAccounts().size());
    }
}
