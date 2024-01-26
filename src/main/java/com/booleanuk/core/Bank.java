package com.booleanuk.core;

import java.util.*;


public class Bank {

    private HashMap<Customer, ArrayList<Account>> accounts;
    private ArrayList<OverdraftRequest> overdraftRequests;

    private Scanner scanner = new Scanner(System.in);

    public Bank() {
        accounts = new HashMap<>();
        overdraftRequests = new ArrayList<>();
    }

    public int createCurrentAccount(Customer customer) {
        Account account = new CurrentAccount(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }

    public int createSavingsAccount(Customer customer) {
        Account account = new SavingsAccount(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }


    // For testing purposes
    protected ArrayList<Account> getAccounts(Customer customer) {
        return accounts.get(customer);
    }

    private void addAccountToCustomer(Customer customer, Account account) {
        if(accounts.containsKey(customer)) {
            ArrayList<Account> customerAccounts = accounts.get(customer);
            customerAccounts.add(account);
            accounts.put(customer, customerAccounts);
            return;
        }
        accounts.put(customer, new ArrayList<>(Collections.singletonList(account)));
    }

    public String deposit(double amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                customerAccount.deposit(amount);
                return "The deposit has been performed.";
            }
        }
        return "Account doesn't exist.";
    }

    public String withdraw(double amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                if(customerAccount.withdraw(amount)) {
                    return "The withdrawal has been performed.";
                } else {
                    return "The withdrawal could not be performed.";
                }
            }
        }
        return "Account doesn't exist.";
    }

    public String generateBankStatements(Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                return customerAccount.generateStatements();
            }
        }
        return "Account doesn't exist.";
    }

    public String requestsOverdraft(Customer customer, int accountId, double amount) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                if(customerAccount instanceof SavingsAccount) {
                    return "You can't have an overdraft on a savings account.";
                } else if (((CurrentAccount) customerAccount).getAllowedOverdraft() >= amount) {
                    return "You already have an approved overdraft for this account and amount.";
                } else {
                    overdraftRequests.add(new OverdraftRequest(customer, accountId, amount));
                    return "Your request has been sent.";
                }

            }
        }


        return "Account doesn't exist.";
    }

    public void goThroughOverdraftRequests() {
        System.out.println("Press [y]es to approve, [n]o to reject and [q] to quit.\n\n");
        ArrayList<OverdraftRequest> toRemove = new ArrayList<>();

        String input = "";
        for(int i = 0; i < overdraftRequests.size() && !input.equalsIgnoreCase("q"); i++) {
            OverdraftRequest overdraftRequest = overdraftRequests.get(i);
            System.out.println("\n"+overdraftRequest);
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("y")) {
                approveOverdraftRequest(overdraftRequest);
                toRemove.add(overdraftRequest);
            } else if(input.equalsIgnoreCase("n")) {
                toRemove.add(overdraftRequest);
            }
        }

        for(OverdraftRequest overdraftRequest: toRemove) {
            overdraftRequests.remove(overdraftRequest);
        }

    }

    //For testing purposes
    protected void approveAllOverdraftRequest() {
        for(OverdraftRequest overdraftRequest: overdraftRequests) {
            approveOverdraftRequest(overdraftRequest);
        }

    }

    //For testing purposes
    protected void approveOverdraftRequest(Customer customer, int account, double overdraft) {
        OverdraftRequest overdraftRequest = new OverdraftRequest(customer, account, overdraft);
        approveOverdraftRequest(overdraftRequest);
        overdraftRequests.remove(overdraftRequest);
    }

    //For testing purposes
    protected void rejectOverdraftRequest(Customer customer, int account, double overdraft) {
        OverdraftRequest overdraftRequest = new OverdraftRequest(customer, account, overdraft);
        overdraftRequests.remove(overdraftRequest);
    }

    private void approveOverdraftRequest(OverdraftRequest overdraftRequest) {
        for(Account account: accounts.get(overdraftRequest.getCustomer())) {
            if(account.getId() == overdraftRequest.getAccountId()) {
                ((CurrentAccount) account).setAllowedOverdraft(overdraftRequest.getOverdraft());
            }
        }

    }
}
