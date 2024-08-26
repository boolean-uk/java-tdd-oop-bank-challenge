package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
	private final ArrayList<BankAccount> accounts;
	private final Bank bank;
	private final String name;

	public Customer(Bank bank, String name){
		accounts = new ArrayList<>();
		this.bank = bank;
		this.name = name;
	}

	public BankAccount createAccount(BankType banktype){
		BankAccount ba = new BankAccount(this);
		ba.setBankType(banktype);
		bank.addBankAccount(ba);
		accounts.add(ba);
		return ba;
	}

	public void requestOverdraft(BankAccount ba){
		bank.createOverdraftRequest(ba);
	}

	public BankAccount getAccount(int index){
		return accounts.get(index);
	}

	public String generateStatements(){
		StringBuilder prettystmts = new StringBuilder();
		for(BankAccount b: accounts){
			prettystmts.append(b.generateStatement());
			prettystmts.append("\n\n");
		}
		return prettystmts.toString();
	}

}
