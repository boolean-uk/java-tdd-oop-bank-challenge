package com.booleanuk.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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




    @Test
    public void shouldReturnBalanceForAccount(){
        //given
        Account acc1 = accountManager.createAccount(client);
        //when
        BigDecimal balance  = accountManager.calculateAccountBalance(acc1);
        //then
        assertEquals(BigDecimal.valueOf(0),balance );
    }

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
        assertEquals(BigDecimal.valueOf(10000),balance);
    }


    @Test
    public void shouldAddBalanceToAccount(){
        //given
        Account account1 = accountManager.createAccount(client);
        BigDecimal deposit = BigDecimal.valueOf(1000);
        //when
        accountManager.addDeposit(account1,deposit);
        //then
        assertEquals(BigDecimal.valueOf(1000),accountManager.calculateAccountBalance(account1));
    }

    @Test
    public  void shouldReturn5000AfterWithdraw6000FromAccount(){
        //given
        Account account1 = accountManager.createAccount(client);
        BigDecimal deposit = BigDecimal.valueOf(11000);
        accountManager.addDeposit(account1,deposit);
        BigDecimal withdraw = BigDecimal.valueOf(6000);
        //when
        accountManager.withdraw(account1,withdraw);
        //then
        assertEquals(BigDecimal.valueOf(5000),accountManager.calculateAccountBalance(account1));


    }

    @Test
    public void shouldNotWithDrawMoneyBelowZero() {
        //given
        Account account1 = accountManager.createAccount(client);
        BigDecimal deposit = BigDecimal.valueOf(11000);
        accountManager.addDeposit(account1, deposit);
        BigDecimal withdraw = BigDecimal.valueOf(-6000);
        //when
        accountManager.withdraw(account1, withdraw);
        //then
        assertEquals(BigDecimal.valueOf(11000), accountManager.calculateAccountBalance(account1));
    }

    @Test
    public void shouldReturnBankStatementForAccount(){
        //given
        Account account1 = accountManager.createAccount(client);
        BigDecimal deposit = BigDecimal.valueOf(11000);
        BigDecimal withdraw = BigDecimal.valueOf(1000);
        accountManager.addDeposit(account1, deposit);
        accountManager.addDeposit(account1, deposit);
        accountManager.addDeposit(account1, deposit);
        //when
        String bankStatement = accountManager.generateBankStatement(account1);
        //then
        assertEquals("",bankStatement);
    }
}
