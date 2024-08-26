package com.booleanuk.core;

import java.util.ArrayList;

public class BankAccount {
	private final String bank;
	private boolean canOverdraft;
	private ArrayList<Transaction> transactions;

	public BankAccount(String bank){
		this.bank = bank;
		this.canOverdraft = false; // defaulted to false
		this.transactions = new ArrayList<>();
	}

	public String generateStatement(){
		return "";
	}

	public String deposit(double amount){
		this.transactions.add(new Transaction(amount));
		return "Added " + amount + " to account.";
	}

	public String withdraw(double amount){
		// check current amount of money in account

		// if more than amount || if can overdraft
			// -> withdraw

		return "withdrew from account";
	}

	public void RequestOverdraft(){

	}
}
