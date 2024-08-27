package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManager {
	@Test
	public void testManagerCanManageOverdraft(){
		Bank b = new Bank(Branch.Oslo);
		Manager m = new Manager(b);
		Customer c = new Customer(b, "MyName");
		BankAccount ba = c.createAccount(BankType.Debit);
		ba.requestOverdraft();


		// assert default false
		Assertions.assertFalse(ba.canOverdraft());

		// set true
		m.concludeOverdraftRequestByIndex(true, 0);
		Assertions.assertTrue(ba.canOverdraft());

		// make new request and deny
		ba.requestOverdraft();
		m.concludeOverdraftRequestByIndex(false, 0);

		// assert denied account
		Assertions.assertFalse(ba.canOverdraft());
	}
}
