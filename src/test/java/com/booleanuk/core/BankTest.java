package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void registerCorrectDataClientDoesNotExistTest() throws Exception {
        Bank bank = new Bank();
        String name = "Chris";
        String lastName = "Test";
        String birthDate = "01.12.1990";
        String id = "123";
        Assertions.assertEquals(null, bank.getClientByID(id));

        bank.register(name, lastName, birthDate, id);

        Assertions.assertEquals(bank.getClientByID(id).name, name);
        Assertions.assertEquals(bank.getClientByID(id).lastName, lastName);
        Assertions.assertEquals(bank.getClientByID(id).birthDate, birthDate);
    }

    @Test
    public void registerCorrectDataButClientExistsInBankTest() throws Exception {
        Bank bank = new Bank();
        String name = "Chris";
        String lastName = "Test";
        String birthDate = "01121990";
        String id = "234";
        Assertions.assertThrows(Exception.class, () -> bank.register(name, lastName, birthDate, id), "Can not be registered");
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
    public void checkIfClientRegisteredIsNotRegisterTest() {
        Bank bank = new Bank();
        Client client = new Client("Chris", "Test", "01.12.1990", "123");
        Assertions.assertFalse(bank.checkIfClientRegistered(client.id));
    }

    @Test
    public void checkIfClientRegisteredIsRegisterTest() {
        Bank bank = new Bank();
        Client client = new Client("Chris", "Test", "01.12.1990", "234");
        Assertions.assertTrue(bank.checkIfClientRegistered(client.id));
    }
}
