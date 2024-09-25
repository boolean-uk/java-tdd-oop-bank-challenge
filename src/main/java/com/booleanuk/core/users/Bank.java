package com.booleanuk.core.users;

import com.booleanuk.core.accounts.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Bank {
    private static List<Customer> customerList;
    private static List<BankManager> bankManagerList;

    public Bank() {
        customerList = new ArrayList<>();
        bankManagerList = new ArrayList<>();
    }

    public static Optional<BankManager> getBranch(String branchId){
        return bankManagerList.stream().filter(a -> Objects.equals(a.getBranchID(), branchId)).findFirst();
    }

    public void addCustomer(String name, String surname, String login, String password, String branchID){
        Optional<BankManager> b = getBranch(branchID);
        if (b.isPresent()){
            Customer c = new Customer( name,  surname,  login,  password,  branchID);
            customerList.add(c);
            b.get().addCustomer(c);
        }
    }

    public void addBankManager(String name, String surname, String login, String password, String branchID){
        bankManagerList.add(new BankManager( name,  surname,  login,  password,  branchID));
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static List<BankManager> getBankManagerList() {
        return bankManagerList;
    }

    public static void reset(){
        customerList.clear();
        bankManagerList.clear();
        Customer.customerCount = 0;
        BankManager.managerCount = 0;
        Account.setAccountCount(0);

    }
}
