package com.booleanuk.core;

public class Manager {
	private Branch branch;
	private Bank bank;

	public Manager(Bank b){
		this.bank = b;
		this.branch = b.getBranch();
	}

	public void concludeOverdraftRequestByIndex(boolean isAccepted, int index){
		OverdraftRequest or = bank.getOverdraftRequest(index);
		if(isAccepted){
			or.accept();
			return;
		}
		or.deny();
	}
}
