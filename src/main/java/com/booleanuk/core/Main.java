package com.booleanuk.core;

public class Main {

    public static void main(String[] args){
        Branch branch = new Branch("Oslo Branch");
        Customer customer = new Customer("Customer1", branch);

        // add amount to currentAccount
        customer.getCurrentAccount().deposit(100);
        customer.getCurrentAccount().deposit(100);
        customer.getCurrentAccount().deposit(100);
        customer.getCurrentAccount().deposit(100);

        // wihdraw
        customer.getCurrentAccount().withdraw(100);

        BankStatement.printStatement(customer.getCurrentAccount());
    }
}
