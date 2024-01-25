package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	public void depositTest(){

		String branch="123456";
		Account acc = new AccountCurr(branch);
		Account acs = new AccountSave(branch);
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(1000,acc.calcBalance());
		Assertions.assertEquals(1000,acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(2000,acc.calcBalance());
		Assertions.assertEquals(2000,acs.calcBalance());

	}
	@Test
	public void withdrawTest(){
		String branch="123456";
		Account acc = new AccountCurr(branch);
		Account acs = new AccountSave(branch);
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(1000,acc.calcBalance());
		Assertions.assertEquals(1000,acs.calcBalance());
		acc.deposit(1000);
		acs.deposit(1000);
		Assertions.assertEquals(2000,acc.calcBalance());
		Assertions.assertEquals(2000,acs.calcBalance());
		try {
			acc.withdraw(500);
			acs.withdraw(500);
			Assertions.assertEquals(1500, acc.calcBalance());
			Assertions.assertEquals(1500, acs.calcBalance());
			acc.withdraw(1000);
			acs.withdraw(1000);
			Assertions.assertEquals(1000, acc.calcBalance());
			Assertions.assertEquals(1000, acs.calcBalance());
			acc.withdraw(2000);
			acs.withdraw(2000);
		}catch (Exception e){
			System.out.println(e);
		}

	}

}
