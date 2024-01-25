package com.booleanuk.core;

import java.util.ArrayList;

class Account {
	ArrayList<Statement> statements;
	String accountId;
	String branch;

	public ArrayList<Statement> getStatements() {
		return statements;
	}

	public void setStatements(ArrayList<Statement> statements) {
		this.statements = statements;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Account(String accountId, String branch) {
		this.accountId = accountId;
		this.branch = branch;
		statements = new ArrayList<>();
	}

	public void deposit(int amount) {
		Statement stat = new Statement("deposit", amount);
		statements.add(stat);
	}

	public double calcBalance() {
		double balance = 0;
		for (Statement stat : statements) {
			if (stat.getType().equals("deposit")) {

				balance += stat.getAmount();
			} else if (stat.getType().equals("withdraw")) {
				balance -= stat.getAmount();
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
	private boolean overdraftEnabled = false;
	private int overdraftLimit = 0;

	public AccountCurr(String accountId, String branch) {
		super(accountId, branch);
	}

	public void withdraw(int amount) throws OverdraftException {

		if (calcBalance() > amount || (overdraftEnabled && calcBalance() + overdraftLimit > amount)) {
			Statement stat = new Statement("withdraw", amount);
			statements.add(stat);
		} else {
			throw new OverdraftException(accountId, amount);
		}
	}

	public boolean isOverdraftEnabled() {
		return overdraftEnabled;
	}

	public void setOverdraftEnabled(boolean overdraftEnabled) {
		this.overdraftEnabled = overdraftEnabled;
	}

	public void setOverdraftLimit(int limit) {
		this.overdraftLimit = Math.max(limit, 0);
	}
}

class AccountSave extends Account {


	public AccountSave(String accountId, String branch) {
		super(accountId, branch);
	}
}
