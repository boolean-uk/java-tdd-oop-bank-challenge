package com.booleanuk.core;

public class BankAccountDebit extends BankAccount{
	private int maxOverdraft;
	public BankAccountDebit(Customer customer) {
		super(customer);
		maxOverdraft = 10000;
	}

	@Override
	public String withdraw(double amount){
		// if can go below zero
		if (canOverdraft && maxOverdraft + getBalance() >= amount){
			transactions.add(new Transaction(-amount));
			return "withdrew " + amount + " from account.";
		}

		// if cant: check if balance >= amount
		double balance = getBalance();
		if(balance >= amount){
			transactions.add(new Transaction(-amount));
			return "withdrew " + amount + " from account.";
		}

		return "Couldn't withdraw " + amount + " from account.";
	}


}
