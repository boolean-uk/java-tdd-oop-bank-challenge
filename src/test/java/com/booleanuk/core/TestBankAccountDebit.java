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

	@Test
	public void testWithdrawBelowZero(){
		Bank b = new Bank(Branch.Oslo);
		Customer c = b.createCustomer("Kåre Kåre Kåre");
		BankAccount ba = c.createAccount(BankType.Debit);
		String ans  = ba.withdraw(1000);
		String expected = "Couldn't withdraw 1000.0 from account.";
		Assertions.assertEquals(expected, ans);

		boolean sentRequest = ba.requestOverdraft();
		Assertions.assertTrue(sentRequest);

		OverdraftRequest or = b.getOverdraftRequest(0);
		or.accept();

		ans  = ba.withdraw(1000);
		expected = "withdrew " + 1000.0 +  " from account.";
		Assertions.assertEquals(expected, ans);
	}

	@Test
	public void testOverdraft(){
		Bank b = new Bank(Branch.Oslo);
		Customer c = b.createCustomer("Kåre Kåre Kåre");
		BankAccount ba = c.createAccount(BankType.Debit);
		ba.setCanOverdraft(true);
		ba.deposit(20000);



		String result = ba.withdraw(35000);
		String expected = "Couldn't withdraw " + 35000d + " from account.";
		Assertions.assertEquals(expected, result);

		result = ba.withdraw(25000);
		expected = "withdrew " + 25000d + " from account.";
		Assertions.assertEquals(expected, result);

		// bva testing
		BankAccount ba2 = c.createAccount(BankType.Debit);
		ba2.setCanOverdraft(true);
		result = ba2.withdraw(10000);
		expected = "withdrew " + 10000d + " from account.";
		Assertions.assertEquals(expected, result);

		BankAccount ba3 = c.createAccount(BankType.Debit);
		ba3.setCanOverdraft(true);
		result = ba3.withdraw(10000.0001);
		expected = "Couldn't withdraw " + 10000.0001d + " from account.";
		Assertions.assertEquals(expected, result);


	}





















}
