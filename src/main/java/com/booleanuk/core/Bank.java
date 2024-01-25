package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Bank {
	private HashMap<String, AccountCurr> accountsCurr;
	private HashMap<String, AccountSave> accountsSave;
	private ArrayList<String> requests;

	public Bank() {
		accountsCurr = new HashMap<>();
		accountsSave = new HashMap<>();
		requests = new ArrayList<>();
	}

	public void createAccountCurr(AccountCurr account) {
		accountsCurr.put(account.getAccountId(), account);
	}

	public void createAccountSave(AccountSave account) {
		accountsSave.put(account.getAccountId(), account);

	}

	public HashMap<String, AccountCurr> getAccountsCurr() {
		return accountsCurr;
	}

	public void setAccountsCurr(HashMap<String, AccountCurr> accountsCurr) {
		this.accountsCurr = accountsCurr;
	}

	public HashMap<String, AccountSave> getAccountsSave() {
		return accountsSave;
	}

	public void setAccountsSave(HashMap<String, AccountSave> accountsSave) {
		this.accountsSave = accountsSave;
	}

	public ArrayList<String> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<String> requests) {
		this.requests = requests;
	}

	public Account getAccount(String accountId) {
		if (accountsCurr.containsKey(accountId))
			return accountsCurr.get(accountId);
		if (accountsSave.containsKey(accountId))
			return accountsSave.get(accountId);

		throw new RuntimeException();
	}


	public String generateStatements(String accountId) {
		Account acc = getAccount(accountId);
		ArrayList<Statement> statements = new ArrayList<>(acc.getStatements());
		Collections.reverse(statements);

		double maxWidth = 7;
		if (maxWidth < findMaxAmountWidth(statements)) {
			maxWidth = findMaxAmountWidth(statements);
		}
		double balance = getBalance(accountId);
		StringBuilder sb = new StringBuilder("date       || credit  ||  debit  || balance\n");
		for (Statement statement : statements) {
			if (statement.getType().equals("deposit")) {
				sb.append(String.format("%-10s", statement.getDate()));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", statement.getAmount()));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", ""));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", balance));
				balance -= statement.getAmount();
				sb.append("\n");

			}
			if (statement.getType().equals("withdraw")) {
				sb.append(String.format("%-10s", statement.getDate()));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", ""));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", statement.getAmount()));
				sb.append(" || ");
				sb.append(String.format("%" + (int) maxWidth + "s", balance));
				balance += statement.getAmount();
				sb.append("\n");

			}
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	private double findMaxAmountWidth(ArrayList<Statement> statements) {
		double maxAmount = 0.0;

		for (Statement statement : statements) {
			double amount = Math.abs(statement.getAmount());
			if (amount > maxAmount) {
				maxAmount = amount;
			}
		}
		return Math.ceil(Math.log10(maxAmount))+2;
	}

	public double getBalance(String accountId) {
		return getAccount(accountId).calcBalance();
	}

	public void requestOverdraft(String accountId) throws NotFoundException {
		if (accountsCurr.containsKey(accountId)) {
			requests.add(accountId);
		} else {
			throw new NotFoundException(accountId);
		}
	}

	public String answerNextRequest(boolean answer) {
		if (requests.isEmpty()) {
			return "No pending requests";
		}
		accountsCurr.get(requests.get(0)).setOverdraftEnabled(answer);
		String s = "Overdraft for account " + requests.get(0) + " is now " + answer;
		requests.remove(0);
		return s;
	}

	public String answerRequest(boolean answer, int index) {
		if (requests.size() > index) {
			accountsCurr.get(requests.get(index)).setOverdraftEnabled(answer);
			String s = "Overdraft for account " + requests.get(index) + " is now " + answer;
			requests.remove(0);
			return s;
		}
		return "Not a valid request";
	}
}
