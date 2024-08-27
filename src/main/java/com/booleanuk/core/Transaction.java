package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
	public final double amount;
	public final LocalDateTime date;

	public Transaction(double amount){
		this.amount = amount;
		this.date = LocalDateTime.now();
	}

	public double getAmount() {
		return amount;
	}
}
