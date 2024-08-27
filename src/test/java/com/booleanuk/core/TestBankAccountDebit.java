package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBankAccountDebit {

	@Test
	public void testBankAccountDebitConstr(){
		BankAccountDebit ba = new BankAccountDebit(new Customer(new Bank(Branch.Oslo), "Ole"));
	}


	@Test
	public void testDepositAndWithDraw(){
		BankAccountDebit ba = new BankAccountDebit(new Customer(new Bank(Branch.Oslo), "Ole"));
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

	@Test
	public void testGenerateBankStatement(){
		BankAccountDebit ba = new BankAccountDebit(new Customer(new Bank(Branch.Oslo), "Ole"));
		ba.deposit(1500);
		ba.withdraw(300);
		ba.deposit(500);

		String result = ba.generateStatement();
		String expected = "  2024-08-26 ||      500.0 ||            ||   1700.0\n" +
				"  2024-08-26 ||            ||      300.0 ||   1200.0\n" +
				"  2024-08-26 ||     1500.0 ||            ||   1500.0";
		Assertions.assertTrue(result.contains(expected));

		ba.withdraw(750);
		result = ba.generateStatement();
		expected = "    date     ||  deposit   ||  withdraw  || balance \n" +
				"  2024-08-26 ||            ||      750.0 ||    950.0\n" +
				"  2024-08-26 ||      500.0 ||            ||   1700.0";

		Assertions.assertTrue(result.contains(expected));


	}

}
