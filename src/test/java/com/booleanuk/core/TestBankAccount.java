package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBankAccount {

	@Test
	public void testBankAccountConstr(){
		BankAccount ba = new BankAccount(new Customer(new Bank(Branch.Oslo), "Ole"));
	}


	@Test
	public void testDepositAndWithDraw(){
		BankAccount ba = new BankAccount(new Customer(new Bank(Branch.Oslo), "Ole"));
		double balance;
		balance = ba.getBalance();
		Assertions.assertEquals(0, balance);

		ba.deposit(15);
		balance = ba.getBalance();
		Assertions.assertEquals(15, balance);


		ba.withdraw(3);
		balance = ba.getBalance();
		Assertions.assertEquals(12, balance);

	}

}
