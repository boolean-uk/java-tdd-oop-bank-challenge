package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBankAccountSavings {
	@Test
	public void testSavingsWithdraw(){
		Customer c = new Customer(new Bank(Branch.Oslo), "Ålløh dah");
		BankAccountSavings bas = new BankAccountSavings(c);
		bas.deposit(2500);
		String firstStatement = bas.generateStatement();

		String expectex = "can not withdraw from savingsacconut";
		String result = bas.withdraw(2000);

		Assertions.assertEquals(expectex, result);

		String secondStatement = bas.generateStatement();
		Assertions.assertEquals(firstStatement, secondStatement);
	}

	@Test
	public void testRequestOverdraft(){
		Bank b = new Bank(Branch.Oslo);
		Customer c = new Customer(b, "Ålløh dah");
		BankAccountSavings bas = new BankAccountSavings(c);

		boolean result = bas.requestOverdraft();
		Assertions.assertFalse(result);

		ArrayList<OverdraftRequest> res = b.getOverdraftRequests();
		Assertions.assertEquals(new ArrayList<OverdraftRequest>(), res);

	}
}
