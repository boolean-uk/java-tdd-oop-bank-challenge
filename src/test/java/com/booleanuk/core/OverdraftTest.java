package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftTest {

//
    @Test
    void shouldWithdrawMoreWithOverdraftTrue() {
        Customer customer = new Customer();
        customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        CustomerAccount creditAccount = customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        while(!creditAccount.isOverdraft()){
            customer.requestOverDraft(creditAccount);
        }
        Assertions.assertTrue(customer.withdraw(creditAccount,50));
    }
    @Test
    void shouldWithdrawMoreWithOverdraftFalse() {
        Customer customer = new Customer();
        customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        CustomerAccount creditAccount = customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        while(creditAccount.isOverdraft()){
            customer.requestOverDraft(creditAccount);
        }
        Assertions.assertFalse(customer.withdraw(creditAccount,50));
    }
}
