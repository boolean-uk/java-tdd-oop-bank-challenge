package com.booleanuk.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BankManagmentTest {
    CurrentAccount currentAccount;
    User user;
    User secondUser;
    CurrentAccount secondAccount;
    User manager;

    @BeforeEach
    public void setup(){
        user = new User("Wojtek");
        secondUser = new User("Kuba");
        manager = new User("Milena");
        manager.setManager(true);
        currentAccount = new CurrentAccount("PL8",user,manager);

    }
    @AfterEach
    public void clear(){
        Bank.getAccountList().clear();
    }


    @Test
    public void shouldDepositMoney(){
        currentAccount.deposit(1000.00);
        assertEquals(1, currentAccount.getTransactions().size());
        assertEquals(1000.00, currentAccount.getTransactions().get(0).getAmount());
    }

    @Test
    public void shouldWithdrawMoney(){
        currentAccount.deposit(1500.00);
        currentAccount.withdraw(1000.00);
        assertEquals(2, currentAccount.getTransactions().size());
        assertEquals(1000, currentAccount.getTransactions().get(1).getAmount());

        assertThrows(IllegalArgumentException.class,()-> currentAccount.withdraw(1000));
    }

    @Test
    public void shouldWireMoney(){
        secondAccount = new CurrentAccount("POL54", secondUser, manager);
        currentAccount.deposit(1000);
        currentAccount.wire(600.00,secondAccount.getAccountNumber());
        assertEquals(400.00,currentAccount.getBalance());


    }
    @Test
    public void shouldGetBalance(){
        secondAccount = new CurrentAccount("POL54", secondUser, manager);
        currentAccount.deposit(1000.00);
        currentAccount.deposit(1500.00);
        currentAccount.wire(100.00,secondAccount.getAccountNumber());
        currentAccount.withdraw(700.00);
        assertEquals(1700.00, currentAccount.getBalance());
    }
    @Test
    public void shouldGetCorrectStatement(){
        secondAccount = new CurrentAccount("POL86", secondUser, manager);
        CurrentAccount thirdAccount = new CurrentAccount("PL145", user, manager);
        currentAccount.deposit(1000.00);
        currentAccount.deposit(1500.00);
        currentAccount.wire(100.00,secondAccount.getAccountNumber());
        currentAccount.withdraw(700.00);
        thirdAccount.deposit(100);
        thirdAccount.deposit(1500);
        thirdAccount.withdraw(500);
        Map<Account,List<Transaction>> expected = new HashMap<>();
        expected.put(currentAccount,currentAccount.getTransactions());
        expected.put(thirdAccount,thirdAccount.getTransactions());
        System.out.println(user.generateStatement().toString());
        assertEquals(expected,user.generateStatement().getTransactions());
    }

    @Test
    public void shouldSendARequest(){

        Request request = new Request(2000,currentAccount);
        assertEquals(request,user.sendRequest(2000,currentAccount.getAccountNumber()));
    }

    @Test
    public void shouldApproveRequest(){
        Request request = new Request(2000,currentAccount);
        user.sendRequest(2000,currentAccount.getAccountNumber());
        assertEquals(-2000,currentAccount.getBalance());
        assertTrue(manager.approveRequest(request));
        assertFalse(user.approveRequest(request));
    }

    @Test
    public void shouldGetAccountsByBranch(){
        CurrentAccount account2 = new CurrentAccount("PL14",user,manager);
        SavingAccount account3 = new SavingAccount("PL8",user,manager);
        assertEquals(2,manager.getAccountsByBranch("PL8").size());
        assertThrows(IllegalArgumentException.class,()->user.getAccountsByBranch("PL8"));
    }
}
