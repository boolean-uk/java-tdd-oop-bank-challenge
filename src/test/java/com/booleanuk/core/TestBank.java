package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBank {
	@Test
	public void testConstr(){
		Bank b = new Bank(Branch.Oslo);
	}

	@Test
	public void testOverdraft(){
		Bank b = new Bank(Branch.Oslo);
		BankAccount ba = new BankAccount(new Customer(b, "Ole"));

		Assertions.assertTrue(b.getOverdraftRequests().isEmpty());
		ba.RequestOverdraft();
		Assertions.assertFalse(b.getOverdraftRequests().isEmpty());

		OverdraftRequest ora = b.getOverdraftRequest(0);
		Assertions.assertFalse(ba.canOverdraft());
		ora.accept();
		Assertions.assertTrue(ba.canOverdraft());

		ora.deny();
		Assertions.assertFalse(ba.canOverdraft());
	}

	@Test
	public void testCreateCustomer(){
		Bank b = new Bank(Branch.Oslo);
		// check if empty list
		Assertions.assertTrue(b.getCustomers().isEmpty());

		b.createCustomer("Ola Normann");
		Assertions.assertFalse(b.getCustomers().isEmpty());
	}
}
