package com.booleanuk.core;

public class NotFoundException extends Exception {
	public NotFoundException(String accountId) {
		super("Could not find account " + accountId + ".");
	}
}
