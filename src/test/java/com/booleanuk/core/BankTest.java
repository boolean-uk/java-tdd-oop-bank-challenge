package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    AccountManager accountManager;

    @BeforeEach
    public  void prepareForTests(){
        accountManager = new AccountManager();
    }


    @Test
    public void shouldCreateAccountForClient(){
        //given
        Client client1 = new Client("John","Smith");
        //when
        Account account1 = accountManager.createAccount(client1);
        //then
        assertTrue(accountManager.getAccounts().contains(account1));

    }


  /*  @Test
    public void shouldReturnBalanceForAccount(){
        //given
        //when
        BigDecimal balance  = accountManager.calculateAccountBalance(account);
        //then
        assertEquals(BigDecimal.valueOf(10000),balance );
    }*/
}
