package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOverdraftRequests {
	@Test
	public void testOverdraftRequest(){
		BankAccount ba = new BankAccountDebit(new Customer(new Bank(Branch.Oslo), "Ole"));
		OverdraftRequest or = new OverdraftRequest(ba);

		Assertions.assertFalse(ba.canOverdraft());

		or.accept();
		Assertions.assertTrue(ba.canOverdraft());

		or.deny();
		Assertions.assertFalse(ba.canOverdraft());
	}
}
