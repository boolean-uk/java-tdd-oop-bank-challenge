package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bank {
    private int branchNr = 1;

    ArrayList<Customer> customers;
    ArrayList<Account> accounts;

    public Bank(){
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }
    public Account createAcc(Customer customer,int choice){
        Account account = null;
        int accNr = 0;
        if (accounts != null){
            for (Account acc : accounts) {
                if(accNr < acc.getAccNr()){
                    accNr = acc.getAccNr();
                }
            }
        }

        if(customers.contains(customer)) {
            String type;
            if (choice == 1) {
                accNr++;
                type = "Saving account";
                account = new Saving(accNr, 0, type, customer);
                customer.getAccounts().add(account);
                accounts.add(account);
            } else if (choice == 2) {
                accNr++;
                type = "Current account";
                account = new Saving(accNr, 0, type, customer);
                customer.getAccounts().add(account);
                accounts.add(account);
            }
        }else{
            customers.add(customer);
            String type;
            if (choice == 1) {
                accNr++;
                type = "Saving account";
                account = new Saving(accNr, 0, type, customer);
                customer.getAccounts().add(account);
                accounts.add(account);
            } else if (choice == 2) {
                accNr++;
                type = "Current account";
                account = new Saving(accNr, 0, type, customer);
                customer.getAccounts().add(account);
                accounts.add(account);
            }
        }

        return account;
    }

    public String seeTransactions(Customer customer,int choice){
        String output = "";
        output+="Account\t\tDate and Time\t\t\tDebit\tCredit\t\tBalance\n";
        if (customers == null){
            return "Can't find any customers atm";
        }
        if (accounts == null){
            return "Can't find any accounts atm";
        }
        if(!customers.contains(customer)){
            return "Customer not registered";
        }


        if(choice == 1){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Saving account")){
                    ArrayList<Transaction> transactionsList;
                    transactionsList = (account.getTransactions());
                    for(Transaction transaction : transactionsList){
                        output+= "\t"+transaction.getAccNr();
                        output+= "\t\t"+transaction.getDateTime();
                        output+= "\t\t"+transaction.getDebit();
                        output+= "\t\t"+transaction.getCredit();
                        output+= "\t\t"+transaction.getBalance()+"\n";
                    }
                }
            }

        }else if(choice == 2){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Current account")){
                    ArrayList<Transaction> transactionsList;
                    transactionsList = (account.getTransactions());
                    for(Transaction transaction : transactionsList){
                        output+= transaction.getAccNr();
                        output+= "\t\t"+transaction.getDateTime();
                        output+= "\t\t"+transaction.getDebit();
                        output+= "\t\t"+transaction.getCredit();
                        output+= "\t\t"+transaction.getBalance();
                    }
                }
            }
        }else{
            return "Write a valid choice";
        }
        return output;
    }

    public String makeDeposit(Customer customer,int choice,double amount){
        String output = "";

        if (customers == null){
            return "Can't find any customers atm";
        }
        if (accounts == null){
            return "Can't find any accounts atm";
        }
        if(!customers.contains(customer)){
            return "Customer not registered";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);

        int accNr = 0;
        if(choice == 1){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Saving account")){
                    accNr = account.getAccNr();
                    double oldBalance = account.getBalance();
                    double newBalance = oldBalance + amount;
                    account.setBalance(newBalance);
                    Transaction transaction = new Transaction(accNr,dateTime,newBalance,0,amount,customer);
                    account.getTransactions().add(transaction);
                    return "Added: "+amount+" to balance in account: " +accNr+". New balance is now: "+newBalance;
                }
            }

        }else if(choice == 2){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Current account")){
                    accNr = account.getAccNr();
                    double oldBalance = account.getBalance();
                    double newBalance = oldBalance + amount;
                    account.setBalance(newBalance);
                    Transaction transaction = new Transaction(accNr,dateTime,newBalance,0,amount,customer);
                    account.getTransactions().add(transaction);
                    account.setBalance(newBalance);
                    return "Added: "+amount+" to balance in account: " +accNr+". New balance is now: "+newBalance;

                }
            }
        }else{
            return "Write a valid choice";
        }
        return output;
    }

    public String makeWithdraw(Customer customer,int choice,double amount){
        String output = "1";

        if (customers == null){
            return "Can't find any customers atm";
        }
        if (accounts == null){
            return "Can't find any accounts atm";
        }
        if(!customers.contains(customer)){
            return "Customer not registered";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);

        int accNr = 0;
        if(choice == 1){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Saving account")){
                    accNr = account.getAccNr();
                    double oldBalance = account.getBalance();
                    if(oldBalance > amount) {
                        double newBalance = oldBalance - amount;
                        account.setBalance(newBalance);
                        Transaction transaction = new Transaction(accNr,dateTime,newBalance,amount,0,customer);
                        account.getTransactions().add(transaction);
                        return "Withdrew " + amount + " from balance in account: " + accNr + ". New balance is now: " + newBalance;
                    }else{
                        return "That is too much";
                    }
                }
            }

        }else if(choice == 2){
            for(Account account : accounts){
                if (account.getCustomer().equals(customer) && account.getType().equals("Current account")){
                    accNr = account.getAccNr();
                    double oldBalance = account.getBalance();
                    if(oldBalance < amount) {
                        double newBalance = oldBalance - amount;
                        account.setBalance(newBalance);
                        Transaction transaction = new Transaction(accNr,dateTime,newBalance,amount,0,customer);
                        account.getTransactions().add(transaction);
                        return "Withdrew " + amount + " from balance in account: " + accNr + ". New balance is now: " + newBalance;
                    } else{
                        return "That is too much";
                    }
                }
            }
        }else{
            return "Write a valid choice";
        }
        return output;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2);
        bank.createAcc(customer,1);
        System.out.println(bank.makeDeposit(customer,1,500));
        System.out.println(bank.makeWithdraw(customer,1,250));
        System.out.println(bank.makeDeposit(customer,1,500));
        System.out.println(bank.makeWithdraw(customer,1,250));
        System.out.println(bank.makeDeposit(customer,1,500));
        System.out.println(bank.makeWithdraw(customer,1,250));
        System.out.println(bank.makeDeposit(customer,1,500));
        System.out.println(bank.makeWithdraw(customer,1,250));
        System.out.println(bank.seeTransactions(customer,1));

    }
}
