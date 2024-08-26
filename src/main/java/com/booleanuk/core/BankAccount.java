package com.booleanuk.core;

import java.util.ArrayList;

public class BankAccount {
	private final Customer customer;
	private boolean canOverdraft;
	private ArrayList<Transaction> transactions;
	private BankType bankType;

	public BankAccount(Customer customer){
		this.customer = customer;
		this.canOverdraft = false; // defaulted to false
		this.transactions = new ArrayList<>();
		this.bankType = BankType.Debit;
	}

	public void setBankType(BankType bankType){
		this.bankType = bankType;
	}

	public String generateStatement(){
		return transactions.toString();
	}

	public String deposit(double amount){
		this.transactions.add(new Transaction(amount));
		return "Added " + amount + " to account.";
	}


	private double getBalance(){
		return transactions
				.parallelStream()
				.mapToDouble(transaction -> transaction.getAmount())
				.sum();
	}

	public String withdraw(double amount){
		// if can go below zero
		if (canOverdraft){
			transactions.add(new Transaction(amount));
			return "withdrew " + amount + " from account.";
		}

		// if cant: check if balance >= amount
		double balance = getBalance();
		if(balance >= amount){
			return "withdrew " + amount + " from account.";
		}

		return "Couldn't withdraw " + amount + " from account.";
	}

	public void RequestOverdraft(){
		customer.requestOverdraft(this);
	}

	public void setCanOverdraft(boolean canOverdraft) {
		this.canOverdraft = canOverdraft;
	}

	public boolean canOverdraft(){
		return canOverdraft;
	}
}
