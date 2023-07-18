package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void registerCorrectDataTest() throws Exception {
        Bank bank = new Bank();
        String name = "Chris";
        String lastName = "Test";
        String birthDate = "01.12.1990";
        String id = "123";
        Client client = new Client(name, lastName, birthDate, id);
        bank.register(name, lastName, birthDate, id);

        Assertions.assertEquals(bank.getClientList().stream().filter(e -> e.name.equals(name)).findFirst().orElse(null), client.name);
        Assertions.assertEquals(bank.getClientList().stream().filter(e -> e.lastName.equals(lastName)).findFirst().orElse(null), client.lastName);
        Assertions.assertEquals(bank.getClientList().stream().filter(e -> e.birthDate.equals(birthDate)).findFirst().orElse(null), client.birthDate);
    }

    @Test
    public void registerIncorrectBirthDateTest() throws Exception {
        Bank bank = new Bank();
        String name = "Chris";
        String lastName = "Test";
        String birthDate = "01121990";
        String id = "123";
        Assertions.assertThrows(Exception.class, () -> bank.register(name, lastName, birthDate, id), "Can not be registered");
    }

//    @Test
//    public void registerIncorrectIDTest() throws Exception {
//        Bank bank = new Bank();
//        String name = "Chris";
//        String lastName = "Test";
//        String birthDate = "01121990";
//        String id = "123QW";
//        Assertions.assertThrows(Exception.class, () -> bank.register(name, lastName, birthDate, id), "Can not be registered");
//    }

    @Test
    public void registerCorrectIDButExistsInBankTest() throws Exception {
        Bank bank = new Bank();
        String name = "Chris";
        String lastName = "Test";
        String birthDate = "01121990";
        String id = "234";
        Assertions.assertThrows(Exception.class, () -> bank.register(name, lastName, birthDate, id), "Can not be registered");
    }

    @Test
    public void checkIfClientRegisteredIsNotRegisterTest() {
        Bank bank = new Bank();
        Client client = new Client("Chris", "Test", "01.12.1990", "123");
        Assertions.assertFalse(bank.checkIfClientRegistered(client.id));
    }

    @Test
    public void checkIfClientRegisteredIsRegisterTest() {
        Bank bank = new Bank();
        Client client = new Client("Chris", "Test", "01.12.1990", "234");
        Assertions.assertFalse(bank.checkIfClientRegistered(client.id));
    }
}
