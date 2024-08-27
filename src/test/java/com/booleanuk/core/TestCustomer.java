package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCustomer {
	@Test
	public void testGenerateStatements(){
		Customer c = new Customer(new Bank(Branch.Oslo), "Daffy Duck");
		c.createAccount(BankType.Debit);
		BankAccount b1 = c.getAccount(0);
		b1.deposit(100);
		b1.deposit(170);
		b1.withdraw(30);
		b1.deposit(45); //185

		c.createAccount(BankType.Debit);
		BankAccount b2 = c.getAccount(1);
		b2.deposit(1000);
		b2.withdraw(300);
		b2.deposit(320);

// date will vary
//		date     ||  deposit   ||  withdraw  || balance
//		2024-08-26 ||       45.0 ||            ||    285.0
//		2024-08-26 ||            ||       30.0 ||    240.0
//		2024-08-26 ||      170.0 ||            ||    270.0
//		2024-08-26 ||      100.0 ||            ||    100.0
//
//		date     ||  deposit   ||  withdraw  || balance
//		2024-08-26 ||      320.0 ||            ||   1020.0
//		2024-08-26 ||            ||      300.0 ||    700.0
//		2024-08-26 ||     1000.0 ||            ||   1000.0
		String result = c.generateStatements();
		System.out.println(result);
		String[] expectedToContain = {"285", "240.0", "270", "100", "1020"};
		for(String s : expectedToContain){
			Assertions.assertTrue(result.contains(s));
		}

	}
}
