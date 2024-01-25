package com.booleanuk.core;

public class InvalidAccountIdException extends Throwable {
	public InvalidAccountIdException(String accountId) {
		super("Account ID "+accountId+" is invalid");
	}
}
