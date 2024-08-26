package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
	private ArrayList<BankAccount> accounts;
	private final Bank bank;
	private final String name;

	public Customer(Bank bank, String name){
		accounts = new ArrayList<>();
		this.bank = bank;
		this.name = name;
	}

	public void addAccount(BankAccount bankaccount){
		accounts.add(bankaccount);
	}

	public void createAccount(BankType banktype){
		BankAccount ba = new BankAccount(this);
		bank.addBankAccount(ba);
		accounts.add(ba);
	}

	public void requestOverdraft(BankAccount ba){
		bank.createOverdraftRequest(ba);
	}

}
