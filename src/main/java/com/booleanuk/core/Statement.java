package com.booleanuk.core;

public class Statement {
	private final String type;
	private final int amount;

	public Statement(String type, int amount) {
		this.type = type;
		this.amount = amount;
	}

	public String getType() {
		return this.type;
	}

	public int getAmount() {
		return this.amount;
	}
}
