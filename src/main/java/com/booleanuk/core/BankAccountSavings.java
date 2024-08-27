package com.booleanuk.core;

public class BankAccountSavings extends BankAccount {
	public BankAccountSavings(Customer customer) {
		super(customer);
	}

	@Override
	public String withdraw(double amount){
		return "can not withdraw from savingsacconut";
	}

	@Override
	public boolean requestOverdraft(){
		System.out.println("Can not request overdraft for savings account. " +
				"please transfer to a debit account");
		return false;
	}
}
