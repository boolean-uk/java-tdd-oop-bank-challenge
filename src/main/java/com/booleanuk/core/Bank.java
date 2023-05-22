package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Customer> customers;
    private static ArrayList<Account> accounts;
    private static ArrayList<OverdraftRequest> overdraftRequests;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.overdraftRequests = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static ArrayList<OverdraftRequest> getOverdraftRequests() { return overdraftRequests; }


    public boolean addCustomer (int id) {
        for (Customer customer: getCustomers()) {
            if (customer.getId() == id) {
                System.out.println("User with this id already exists");
                return false;
            }
        }
        getCustomers().add(new Customer(id));
        return true;
    }

    public static void addAccount (int id, int customerId, String accountType) {
        getAccounts().add(new Account(id, customerId, accountType));
    }



    //OVERDRAFT - User Story: 8
    public static void addOverdraft (int accountId, int ammountRequested) {
        getOverdraftRequests().add(new OverdraftRequest(accountId, ammountRequested));
    }

    public void evaluateOverdraft () {

        if (getOverdraftRequests().isEmpty()) {
            System.out.println("No overdraft requests made.");
            return;
        }

        System.out.println("Choose 1: accept this overdraft request, 2: reject, 3: quit");
        for (OverdraftRequest overdraftRequest: getOverdraftRequests()) {
            if (overdraftRequest.getAnswer() == null) {
                int accountId = overdraftRequest.getAccountId();
                for (Customer customer: getCustomers()) {
                    if (accountId == customer.getCurrentAccount().getId()) {
                        System.out.println("Customer with ID: "+ customer.getId() + " with current account balance of: "+customer.getCurrentAccount().calculateBalance()+ " has requested a total of: "+overdraftRequest.getAmmountRequested());
                        break;
                    }
                }

                System.out.println("Enter a number: ");
                int k = new Scanner(System.in).nextInt();
                if (k == 1) {

                    overdraftRequest.setAnswer(true);
                    for (Customer customer: getCustomers()) {
                        if (accountId == customer.getCurrentAccount().getId()) {
                            customer.getCurrentAccount().addWithdrawStatement(overdraftRequest.getAmmountRequested());
                            break;
                        }
                    }

                } else if (k == 2) {
                    overdraftRequest.setAnswer(false);
                } else if (k == 3) {
                    return;
                } else {
                    System.out.println("Please choose 1, 2 or 3");
                }
            }
        }
        System.out.println("No more unevaluated requests.");
    }

}
