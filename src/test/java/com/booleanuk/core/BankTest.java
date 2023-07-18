package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankTest {

    private BigDecimal REF_ACCOUNT_BALANCE=BigDecimal.valueOf(1000);

    @Test
    public void shouldCreateCurrentAccount(){
        Bank bank = new Bank();
        Assertions.assertDoesNotThrow(() -> bank.addAccount());

    }

    @Test
    public void shouldGenerateBankStatement(){
        Bank bank = new Bank();
        Customer customer = new Customer();

        ArrayList<String> test_statement = new ArrayList<>();
        test_statement.add("date       || credit  || debit  || balance");
        test_statement.add("14/01/2012 ||         || 500.00 || 2500.00");
        Assertions.assertEquals(test_statement,customer.printStatement());
    }

    @Test
    public void shouldDepositMoney(){
        Customer customer = new Customer();
        customer.deposit(BigDecimal.valueOf(1000));
        Assertions.assertEquals(REF_ACCOUNT_BALANCE, customer.getBalance());
    }

    @Test
    public void shouldWithdrawMoney(){
        Customer customer = new Customer();
        customer.withdraw(BigDecimal.valueOf(1000));
        Assertions.assertEquals(BigDecimal.ZERO, customer.getBalance());
    }

    @Test
    public void shouldWithdrawMoneyIntoDebt(){
        Customer customer = new Customer();
        customer.withdraw(BigDecimal.valueOf(2000));
        Assertions.assertEquals(REF_ACCOUNT_BALANCE.multiply(BigDecimal.valueOf(-1)), customer.getBalance());
    }

    @Test
    public void shouldBlockWithdrawingMoneyIntoDebt(){
        Customer customer = new Customer();
        Assertions.assertThrows(IllegalStateException.class, () -> customer.withdraw(BigDecimal.valueOf(3000)));
    }

}
