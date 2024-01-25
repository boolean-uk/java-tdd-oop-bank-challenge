package com.booleanuk.core;

import java.util.ArrayList;

class Account {
	ArrayList<Statement> statements;
	String accountId;
	String branch;

	public Account(String accountId, String branch) {
		this.accountId = accountId;
		this.branch = branch;
		statements= new ArrayList<>();
	}

	public void deposit(int amount) {
		Statement stat = new Statement("deposit", amount);
		statements.add(stat);
	}

	public int calcBalance() {
		int balance = 0;
		for (Statement stat : statements) {
			if (stat.getType().equals("deposit")) {

				balance+=stat.getAmount();
			} else if (stat.getType().equals("withdraw")) {
				balance-=stat.getAmount();
			}
		}


		return balance;
	}

	public void withdraw(int amount) throws OverdraftException {
		if (calcBalance() > amount) {
			Statement stat = new Statement("withdraw", amount);
			statements.add(stat);
		} else {
			throw new OverdraftException(accountId, amount);
		}
	}
}

class AccountCurr extends Account {


	public AccountCurr(String accountId, String branch) {
		super(accountId, branch);
	}
}

class AccountSave extends Account {


	public AccountSave(String accountId, String branch) {
		super(accountId, branch);
	}
}
