package com.booleanuk.core;

enum CUSTOMERCODE {
    NOCODE,
    ALREADYEXISTS,
    ACCOUNTDOESNTEXISTS

}

public class Customer {

    final private CustomerAccount[] accounts;
    private CUSTOMERCODE code;

    public Customer() {
        this.accounts = new CustomerAccount[2];
        code = CUSTOMERCODE.NOCODE;
    }

    public CustomerAccount getCredit() {
        return accounts[0];
    }

    public CustomerAccount getSavings() {
        return accounts[1];
    }

    public boolean createCredit() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT);
        if (accountExists(accounts[0])) return false;
        accounts[0] = customerAccount;
        return true;
    }

    public boolean createSavings() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.SAVINGS);
        if (accountExists(accounts[1])) return false;
        accounts[1] = customerAccount;
        return true;
    }

    //todo
    public String printStatements(CustomerAccount account) {
        String statement = "date || credit  || debit  || balance\n";
        if (!accountExists(account)) return statement;
        return statement + account.printStatements(account);
    }

    public boolean deposit(CustomerAccount account, double amount) {
        return accountExists(account) && account.deposit(amount);
    }

    public boolean withdraw(CustomerAccount account, double amount) {
        return accountExists(account) && account.withdraw(amount);
    }


    public boolean requestOverDraft(CustomerAccount account) {
        account.changeOverdraft();
        return account.isOverdraft();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.createCredit();
        System.out.println(customer.requestOverDraft(customer.getCredit()));
    }

    private boolean accountExists(CustomerAccount account) {
        if (account == null) {
            code = CUSTOMERCODE.ACCOUNTDOESNTEXISTS;
            return false;
        }
        for (CustomerAccount customerAccount : accounts) {
            if (customerAccount.getType() == account.getType()) {
                code = CUSTOMERCODE.ALREADYEXISTS;
                return true;
            }
        }
        code = CUSTOMERCODE.NOCODE;
        return false;
    }


}
