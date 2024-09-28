package com.booleanuk.core;

public class Manager {

    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void overdraftRequest(Customer customer) {
        if(customer.getCurrent().getTransactionList().size()+customer.getSavings().getTransactionList().size()>5){
            customer.setOverCheck(true);
            return;
        }
        System.out.println("Not enough transactions for the overdraft");
    }
}
