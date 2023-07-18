package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void toStringTest() {
        Client client = new Client("John", "Smith", "01.02.1998", "1234");
        Assertions.assertEquals("Client{name='John', lastName='Smith', birthDate='01.02.1998', id=1234}", client.toString());
    }
}
