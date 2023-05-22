package com.booleanuk.core;


import java.util.Map;

public class Main {

    public static void main(String[] args){
        Bank alphaBank = new Bank("Alpha Bank");
        Branch alphaAthensBranch = alphaBank.createBranch("Alpha Athens");

        String customerId = alphaAthensBranch.createCustomer();
        Customer customer = alphaAthensBranch.getCustomers().get(customerId);

        String accountId = alphaAthensBranch.createAccount(customerId, Bank.AccountType.CURRENT, 2000);

        customer.getAccounts().get(accountId).withdraw(1000);
        customer.getAccounts().get(accountId).withdraw(1500);
        customer.getAccounts().get(accountId).requestOverdraft(20000);
        BankManager.evaluateOverdraftRequest(customer.getAccounts().get(accountId).getOverdraftRequest(), Bank.OverdraftStatus.ACCEPTED);
        customer.getAccounts().get(accountId).withdraw(10000);
        customer.getAccounts().get(accountId).withdraw(9800);
        customer.getAccounts().get(accountId).withdraw(200);



        System.out.println(customer.getAccounts().get(accountId).getBankStatement());
        Map<String, Account> accounts = alphaAthensBranch.getAllAccounts();
        for(String key : accounts.keySet()){
            System.out.println(alphaAthensBranch.getAllAccounts().get(key).getBalance());
        }


    }
}
