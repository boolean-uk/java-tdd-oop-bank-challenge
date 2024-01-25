package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
	@Test
	public void createCurrAccountTest() {
		String branch = "123456";
		Bank bank = new Bank();
		Assertions.assertEquals(0, bank.getAccountsCurr().size());
		bank.createAccountCurr(new Account("0", branch));
		Assertions.assertEquals(1, bank.getAccountsCurr().size());
		Assertions.assertEquals("0", bank.getAccount("0").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("0").getBranch());
		bank.createAccountCurr(new Account("1", branch));
		Assertions.assertEquals(2, bank.getAccountsCurr().size());
		Assertions.assertEquals("1", bank.getAccount("1").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("1").getBranch());
	}

	@Test
	public void createSaveAccountTest() {
		String branch = "123456";
		Bank bank = new Bank();
		Assertions.assertEquals(0, bank.getAccountsSave().size());
		bank.createAccountSave(new AccountCurr("0", branch));
		Assertions.assertEquals(1, bank.getAccountsSave().size());
		Assertions.assertEquals("0", bank.getAccount("0").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("0").getBranch());
		bank.createAccountSave(new AccountSave("1", branch));
		Assertions.assertEquals(2, bank.getAccountsSave().size());
		Assertions.assertEquals("1", bank.getAccount("1").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("1").getBranch());
	}

	@Test
	public void getBalanceTest() {

	}

	@Test
	public void generateStatementsTest() {
		String branch = "123456";
		Bank bank = new Bank();
		bank.createAccountCurr(new AccountCurr("0", branch));
		bank.getAccount("0").deposit(1000);
		bank.getAccount("0").deposit(2000);
		bank.getAccount("0").withdraw(500);

		String statement =
						"date       || credit  || debit  || balance\n" +
						"25/01/2024 ||         || 500.00 || 2500.00\n" +
						"25/01/2024 || 2000.00 ||        || 3000.00\n" +
						"25/01/2024 || 1000.00 ||        || 1000.00";
		Assertions.assertEquals(statement, bank.generateStatements("0"));
	}


	@Test
	public void requestOverdraftTest() {
	}

	@Test
	public void answerRequestsTest() {
	}


}
