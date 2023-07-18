package com.booleanuk.extension;

import java.time.format.DateTimeFormatter;

public class OverdraftRequest extends Request {
    private final double amount;
    public OverdraftRequest(double amount) {
        super();
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Overdraft request with id: ");
        sb.append(this.getId());
        sb.append(". Submission date: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(this.getDate().format(formatter));
        sb.append(". Amount: ");
        sb.append(amount);
        sb.append(". Status: ");
        sb.append(status.name());
        sb.append(".\n");
        return sb.toString();
    }
}
