package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
	private final ArrayList<Customer> customers;
	private final ArrayList<Manager> managers ;
	private final ArrayList<BankAccount> bankAccounts ;
	private final ArrayList<OverdraftRequest> overdraftRequests  ;
	private final Branch branch;

	public Bank(Branch branch){
		this.customers = new ArrayList<>();
		this.managers = new ArrayList<>();
		this.bankAccounts = new ArrayList<>();
		this.overdraftRequests = new ArrayList<>();
		this.branch = branch;
	}

	public ArrayList<OverdraftRequest> getOverdraftRequests(){
		return overdraftRequests;
	}

	public ArrayList<Customer> getCustomers(){
		return customers;
	}


	public Branch getBranch(){
		return branch;
	}

	public OverdraftRequest getOverdraftRequest(int index){
		return overdraftRequests.remove(index);
	}

	public void createOverdraftRequest(BankAccount ba){
		overdraftRequests.add(new OverdraftRequest(ba));
	}

	public void addCustomer(Customer c){
		customers.add(c);
	}

	public void addManager(Manager m){
		managers.add(m);
	}

	public void addBankAccount(BankAccount bankAccount){
		bankAccounts.add(bankAccount);
	}

	public Customer createCustomer(String name){
		Customer newCustomer = new Customer(this, name);
		customers.add(newCustomer);
		return newCustomer;
	}
}
