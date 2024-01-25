package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankTest {
	@Test
	public void createCurrAccountTest() {
		String branch = "123456";
		Bank bank = new Bank();
		Assertions.assertEquals(0, bank.getAccountsCurr().size());
		bank.createAccountCurr(new AccountCurr("0", branch));
		Assertions.assertEquals(1, bank.getAccountsCurr().size());
		Assertions.assertEquals("0", bank.getAccount("0").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("0").getBranch());
		bank.createAccountCurr(new AccountCurr("1", branch));
		Assertions.assertEquals(2, bank.getAccountsCurr().size());
		Assertions.assertEquals("1", bank.getAccount("1").getAccountId());
		Assertions.assertEquals("123456", bank.getAccount("1").getBranch());
	}

	@Test
	public void createSaveAccountTest() {
		String branch = "123456";
		Bank bank = new Bank();
		Assertions.assertEquals(0, bank.getAccountsSave().size());
		bank.createAccountSave(new AccountSave("0", branch));
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
		String branch = "123456";
		Bank bank = new Bank();
		bank.createAccountCurr(new AccountCurr("0", branch));
		Assertions.assertEquals(0, bank.getBalance("0"));

		bank.getAccount("0").deposit(1000);
		Assertions.assertEquals(1000, bank.getBalance("0"));
		bank.getAccount("0").deposit(2000);
		Assertions.assertEquals(3000, bank.getBalance("0"));
	}

	@Test
	public void generateStatementsTest() {
		String branch = "123456";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		String statement = "";
		Bank bank = new Bank();
		bank.createAccountCurr(new AccountCurr("0", branch));
		statement =
				"date       || credit  ||  debit  || balance";
		Assertions.assertEquals(statement, bank.generateStatements("0"));
		bank.getAccount("0").deposit(1000);
		statement =
				"date       || credit  ||  debit  || balance\n" +
						date + " ||  1000.0 ||         || 1000.0";
		Assertions.assertEquals(statement, bank.generateStatements("0"));
		bank.getAccount("0").deposit(2000);
		statement =
				"date       || credit  ||  debit  || balance\n" +
						date + " ||  2000.0 ||         || 3000.0\n" +
						date + " ||  1000.0 ||         || 1000.0";
		Assertions.assertEquals(statement, bank.generateStatements("0"));
		try {
			bank.getAccount("0").withdraw(500);
		} catch (OverdraftException e) {
			throw new RuntimeException(e);
		}
		statement =
				"date       || credit  ||  debit  || balance\n" +
						date + " ||         ||   500.0 || 2500.0\n" +
						date + " ||  2000.0 ||         || 3000.0\n" +
						date + " ||  1000.0 ||         || 1000.0";
		Assertions.assertEquals(statement, bank.generateStatements("0"));
	}


	@Test
	public void requestOverdraftTest() {
		Bank bank = new Bank();
		AccountCurr ac0 = new AccountCurr("0", "123456");
		AccountCurr ac1 = new AccountCurr("1", "123456");
		Assertions.assertThrows(NotFoundException.class, () -> {
			bank.requestOverdraft("0");
		});
		Assertions.assertThrows(NotFoundException.class, () -> {
			bank.requestOverdraft("1");
		});
		bank.createAccountCurr(ac0);
		bank.createAccountCurr(ac1);
		try {
			bank.requestOverdraft("0");
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			bank.requestOverdraft("1");
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals("0", bank.getRequests().get(0));
		Assertions.assertEquals("1", bank.getRequests().get(1));

	}

	@Test
	public void answerRequestTest() {
		Bank bank = new Bank();
		AccountCurr ac0 = new AccountCurr("0", "123456");
		bank.createAccountCurr(ac0);
		try {
			bank.requestOverdraft("0");
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals("Overdraft for account 0 is now true", bank.answerNextRequest(true));
		Assertions.assertEquals("Not a valid request", bank.answerRequest(true, 1));
		Assertions.assertEquals("No pending requests", bank.answerNextRequest(true));
		Assertions.assertEquals("Not a valid request", bank.answerRequest(true, 0));
		try {
			bank.requestOverdraft("0");
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals("Overdraft for account 0 is now false", bank.answerNextRequest(false));


	}


}
