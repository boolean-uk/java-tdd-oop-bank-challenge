package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

import static com.booleanuk.core.StringUtils.*;

public abstract class BankAccount {
	protected final Customer customer;
	protected boolean canOverdraft;
	protected final ArrayList<Transaction> transactions;

	public BankAccount(Customer customer) {
		this.customer = customer;
		this.canOverdraft = false; // defaulted to false
		this.transactions = new ArrayList<>();
	}


	public String generateStatement(){
		StringBuilder prettyStmt = new StringBuilder();

//		14/01/2012 ||          ||    500.00 || 2500.00
//		13/01/2012 ||  2000.00 ||           || 3000.00
//		10/01/2012 ||  1000.00 ||           || 1000.00
		int datePadding = 12;
		int depositpadding =  10;
		int withdrawPadding = 10;
		int balancePadding = 8;

		//		date       || deposit  || withdraw  || balance
		String dateStr = centerAlignStringWithPadding("date", datePadding);
		String depositStr = centerAlignStringWithPadding("deposit", depositpadding);
		String withdrawStr = centerAlignStringWithPadding("withdraw", withdrawPadding);
		String balanceStr = centerAlignStringWithPadding("balance", balancePadding);

		prettyStmt.append(dateStr + " || " + depositStr + " || " + withdrawStr + " || " + balanceStr);

		// get all the statements
		ArrayList<String> statements = new ArrayList<>();
		double balance = 0;
		for(Transaction t: transactions){
			dateStr = t.date.toLocalDate().toString();
			depositStr = "";
			withdrawStr = "";

			boolean isADeposit = t.getAmount() > 0;
			if(isADeposit)
				depositStr = String.valueOf(formatDoubleToTwoDigits(t.amount));
			else
				withdrawStr = String.valueOf(formatDoubleToTwoDigits(-t.amount));

			balance += t.amount;
			balanceStr = String.valueOf(formatDoubleToTwoDigits(balance));

			dateStr = leftAlignStringWithPadding(dateStr, datePadding);
			depositStr = leftAlignStringWithPadding(depositStr, depositpadding);
			withdrawStr = leftAlignStringWithPadding(withdrawStr, withdrawPadding);
			balanceStr = leftAlignStringWithPadding(balanceStr, balancePadding);

			String stmt = "\n" + dateStr + " || " + depositStr + " || " + withdrawStr + " || " + balanceStr;
			statements.add(stmt);
		}

		Collections.reverse(statements);
		for(String stmt: statements){
			prettyStmt.append(stmt);
		}


		return prettyStmt.toString();
	}

	public String deposit(double amount){
		this.transactions.add(new Transaction(amount));
		return "Added " + amount + " to account.";
	}


	private double formatDoubleToTwoDigits(double amount){
		String doubleStr = String.format("%.2f", amount);
		return Double.valueOf(doubleStr);
	}

	public double getBalance(){
		double balance = transactions
				.parallelStream()
				.mapToDouble(transaction -> transaction.getAmount())
				.sum();

		return formatDoubleToTwoDigits(balance);
	}

	public String withdraw(double amount){
		return "Not implemented withdraw func";
	}

	public boolean requestOverdraft(){
		customer.requestOverdraft(this);
		return true;
	}

	public void setCanOverdraft(boolean canOverdraft) {
		this.canOverdraft = canOverdraft;
	}

	public boolean canOverdraft(){
		return canOverdraft;
	}


}
