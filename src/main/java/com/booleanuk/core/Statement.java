package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Statement {
	private final String type;
	private final double amount;
	private final String date;

	public Statement(String type, int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		this.type = type;
		this.amount = amount;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.date = dateFormat.format(new Date());
	}

	public String getType() {
		return this.type;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getDate() {
		return this.date;
	}
}
