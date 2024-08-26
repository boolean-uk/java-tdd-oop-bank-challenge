package com.booleanuk.core;

public class OverdraftRequest {
	private final BankAccount bankAccount;

	public OverdraftRequest(BankAccount bankAccount){
		this.bankAccount = bankAccount;
	}

	public void accept(){
		bankAccount.setCanOverdraft(true);
	}

	public void deny(){
		bankAccount.setCanOverdraft(false);
	}
}
