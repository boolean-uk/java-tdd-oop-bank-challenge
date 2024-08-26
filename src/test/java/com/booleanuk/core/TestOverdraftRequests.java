package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOverdraftRequests {
	@Test
	public void testOverdraftRequest(){
		BankAccount ba = new BankAccount(new Bank());
		OverdraftRequest or = new OverdraftRequest(ba);

		Assertions.assertFalse(ba.canOverdraft());

		or.accept();
		Assertions.assertTrue(ba.canOverdraft());

		or.deny();
		Assertions.assertFalse(ba.canOverdraft());
	}
}
