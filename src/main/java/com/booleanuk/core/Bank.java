package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    //private HashMap<Customer, ArrayList<Account>> customers;
    private ArrayList<Customer> customers;
    private ArrayList<OverdraftRequest> overdraftRequests;
    private int accountID;
    private int customerID;
    private int transactionID;
    private String branch;

    public Bank(String branch){
        //this.customers = new HashMap<>();
        this.customers = new ArrayList<>();
        this.overdraftRequests = new ArrayList<>();
        this.accountID = 0;
        this.branch = branch;

    }

    public boolean newCustomer(Customer customer){

        if(customerExists(customer)){
            System.out.println("Customer already exists");
            return false;
        }
        customers.add(customer);
        return true;
    }

    public boolean customerExists(Customer customer){
        return customers.contains(customer);
    }

    public Account newAccount(Customer customer, String accountType){

        if (customerExists(customer)){
            if(accountType.equals("Saving")){
                Account newAccount = new SavingsAccount(branch, accountID, this, customer);
                System.out.println("Created new saving account");
                customer.addAccount(newAccount);
                accountID += 1;
                return newAccount;
            }else if(accountType.equals("Current")){
                Account newAccount = new CurrentAccount(branch, accountID, this, customer);
                System.out.println("created new current account for user: " + customer.getName());
                customer.addAccount(newAccount);
                accountID += 1;
                return newAccount;
            }
        }

        return null;
    }

    //added transaction func to Bank so we can keep track of unique transaction ID's
    public double newTransaction(Account account, double depositAmount,double withdrawAmount){
        double newBalance = account.newTransaction(depositAmount, withdrawAmount, transactionID);
        transactionID += 1;
        return newBalance;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public int getAccountID() {
        return accountID;
    }
    public int getCustomerID() {return customerID;}
    public int getTransactionID() {return transactionID;}


    public ArrayList<OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
    }

    public void addOverdraftRequest(OverdraftRequest request) {
        overdraftRequests.add(request);
    }

    public void reviewOverdrafts(){
        Scanner scanner = new Scanner(System.in);
        for(OverdraftRequest r: overdraftRequests){
            Account account = r.getAccount();
            Customer customer = r.getCustomer();
            double overdraftAmount = r.getRequestAmount();

            System.out.println();
            System.out.println("Overdraft Request Details:");
            System.out.println("Customer: " + customer.getName());
            System.out.println("Account balance: " + account.getBalance());
            System.out.println("Requested Overdraft Amount: " + overdraftAmount);

            System.out.println("Do you approve this overdraft request? (yes/no)");

            String decision = scanner.nextLine().trim().toLowerCase();

            if (decision.equals("yes")) {
                account.setOverdraftAmount(overdraftAmount);
                System.out.println("Overdraft request approved.");

            } else if (decision.equals("no")) {
                //overdraftRequests.remove(r);
                System.out.println("Overdraft request denied.");
            } else {
                System.out.println("Invalid input. Please respond with 'yes' or 'no'.");
            }

        }
        overdraftRequests.clear();
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        SavingsAccount savings1 = ((SavingsAccount) bank.newAccount(customer1, "Saving"));
        CurrentAccount current1 = ((CurrentAccount) bank.newAccount(customer1, "Current"));
        bank.newAccount(customer1, "Current");


        savings1.newTransaction(0, 1000, bank.getTransactionID()); //this should fail
        savings1.requestOverdraft(5000.00);


        //try overdrafting with new limits

        bank.reviewOverdrafts();
        savings1.newTransaction(0, 3000, bank.getTransactionID());//This should pass now

        savings1.generateAccountStatement();
    }

}
