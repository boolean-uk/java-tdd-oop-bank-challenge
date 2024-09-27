package com.booleanuk.core;

public class OverdraftException extends Exception {
	public OverdraftException(String accountID,int amount) {
		super("Unable to withdraw "+amount+" from account: "+accountID);
	}
}
