package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	public void depositTest() {

		String branch = "123456";
		AccountCurr acc = new AccountCurr("0", branch);
		AccountSave acs = new AccountSave("1", branch);
		Assertions.assertEquals(0, acc.calcBalance());
		Assertions.assertEquals(0, acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(1000, acc.calcBalance());
		Assertions.assertEquals(1000, acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(2000, acc.calcBalance());
		Assertions.assertEquals(2000, acs.calcBalance());
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			acs.deposit(-1000);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			acc.deposit(-1000);
		});

	}

	@Test
	public void withdrawTest() {
		String branch = "123456";
		AccountCurr acc = new AccountCurr("0", branch);
		AccountSave acs = new AccountSave("1", branch);
		Assertions.assertEquals(0, acc.calcBalance());
		Assertions.assertEquals(0, acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(1000, acc.calcBalance());
		Assertions.assertEquals(1000, acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(2000, acc.calcBalance());
		Assertions.assertEquals(2000, acs.calcBalance());
		try {
			acc.withdraw(500);
			acs.withdraw(500);
			Assertions.assertEquals(1500, acc.calcBalance());
			Assertions.assertEquals(1500, acs.calcBalance());
			acc.withdraw(1000);
			acs.withdraw(1000);
			Assertions.assertEquals(500, acc.calcBalance());
			Assertions.assertEquals(500, acs.calcBalance());

		} catch (OverdraftException e) {
			Assertions.fail();
		}
		Assertions.assertThrows(OverdraftException.class, () -> {
			acc.withdraw(2000);
		});
		Assertions.assertThrows(OverdraftException.class, () -> {
			acs.withdraw(2000);
		});
		acc.setOverdraftLimit(1500);
		acc.setOverdraftEnabled(true);
		try {
			acc.withdraw(1000);
		} catch (OverdraftException e) {
			throw new RuntimeException(e);
		}
		Assertions.assertEquals(-500, acc.calcBalance());
		Assertions.assertThrows(OverdraftException.class, () -> {
			acc.withdraw(2000);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			acs.withdraw(-1000);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			acc.withdraw(-1000);
		});
	}

}
