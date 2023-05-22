package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {

        // USED TO TEST OVERDRAFT

        Bank bank = new Bank();
        bank.addCustomer(1);
        Customer customer = bank.getCustomers().get(0);

        customer.createCurrentAccount(7000);
        customer.requestOverdraft(9000);

        bank.addCustomer(2);
        Customer customer2 = bank.getCustomers().get(1);

        customer2.createCurrentAccount(900);
        customer2.requestOverdraft(1305);

        bank.evaluateOverdraft();
        System.out.println(customer.getOverdraftRequestStatus());
        System.out.println(customer2.getOverdraftRequestStatus());


        customer.generateCurrentAccountStatements();
        System.out.println();
        customer2.generateCurrentAccountStatements();
    }
}
