package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    AccountManager accountManager;
    Client client;
    Account account;

    @BeforeEach
    public  void prepareForTests(){
        accountManager = new AccountManager();
        client = new Client("John","Smith");
        account = accountManager.createAccount(client);
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

    @Test
    public void shouldCreateSavingAccountForClient(){
        //given
        Client client1 = new Client("John","Smith");
        //when
        Account account1 = accountManager.createSavingAccount(client1);
        //then
        assertTrue(accountManager.getAccounts().contains(account1));

    }




/*    @Test
    public void shouldReturnBalanceForAccount(){
        //given
        //when
        BigDecimal balance  = accountManager.calculateAccountBalance(account);
        //then
        assertEquals(BigDecimal.valueOf(10000),balance );
    }*/

    @Test
    public void  shouldReturn0BalanceOfAccount(){
        //when
        BigDecimal balance = account.getBalance();
        //then
        assertEquals(BigDecimal.valueOf(0),balance);
    }

    @Test
    public void  shouldReturn10000BalanceOfAccount(){
        //given
        BigDecimal deposit = BigDecimal.valueOf(5000);
        accountManager.addDeposit(account,deposit);
        accountManager.addDeposit(account,deposit);

        //when
        BigDecimal balance = account.getBalance();
        //then
        assertEquals(BigDecimal.valueOf(5000),balance);
    }


/*    @Test
    public void shouldAddBalanceToAccount(){
        //given
        Account account1 = accountManager.createAccount(client);
        BigDecimal deposit = BigDecimal.valueOf(1000);
        //when
        accountManager.addDeposit(account1,deposit);
        //then
        assertEquals(1000,account1.checkBalance(account1));
    }*/
}
