package com.booleanuk.core;

// Serves as a way for customers to acquire permission to overdraft
// on their account
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
