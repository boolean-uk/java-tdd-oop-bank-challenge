package com.booleanuk.core;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.Random;

public class CurrentAccount extends Account {
    private final Random random;
    public CurrentAccount(){
        super();
        this.random = new Random();
    }
    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(generateRandomDateTime(), amount, TransactionType.DEPOSIT));
    }
    @Override
    public void withdraw(BigDecimal amount){
        if(balance.compareTo(amount)>=0){
            balance = balance.subtract(amount);
            transactions.add(new Transaction(generateRandomDateTime(), amount,TransactionType.WITHDRAWAL));
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    private LocalDateTime generateRandomDateTime(){
        int year = LocalDateTime.now().getYear();
        int month =random.nextInt(12)+1;
        int day =random.nextInt(28)+1;
        int hour =random.nextInt(24);
        int minute =random.nextInt(60);

        return LocalDateTime.of(year,month,day,hour,minute);


    }

}
