package com.booleanuk.extension;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentAccount implements BankAccount {

    private List<Transaction> transactions;
    private double balance;
    private boolean canBeOverdrafted;
    private boolean overdraftRequest;
    private Branch branch;


    public CurrentAccount() {
        transactions = new ArrayList<>();
        //new account is created with balance 0 if you want to add funds
        //you need to use deposit method
        this.balance = 0;
        //account can't be overdrafted on creation but can be later
        //be allowed to be overdrafted but maximum amount of overdraft is equal 500
        canBeOverdrafted = false;
        overdraftRequest = false;
    }

    public CurrentAccount(Branch branch) {
        transactions = new ArrayList<>();
        this.balance = 0;
        canBeOverdrafted = false;
        overdraftRequest = false;
        this.branch = branch;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public double getBalance() {
        return Math.round(balance * 100.0) / 100.0;
    }

    public boolean getCanBeOverdrafted() {
        return canBeOverdrafted;
    }

    public String getBranch() {
        return branch.getBranchName();
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            transactions.add(new Transaction(new Date(), "credit", amount,getBalance()));
            return true;
        }else {
            System.out.println("Amount must be a positive number");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Amount must be a positive number");
            return false;
        }else {
            if(canBeOverdrafted == false) {
                if(getBalance() - amount >= 0) {
                    balance -= amount;
                    transactions.add(new Transaction(new Date(), "debit", amount,getBalance()));
                    return true;
                }else {
                    System.out.println("You can't withdraw more money than there is on the account");
                    System.out.println("You tried to withdraw : " + amount);
                    System.out.println("But you balance is only : " + getBalance());
                    return false;
                }
            } else{
                if(getBalance() - amount >= -500) {
                    balance -= amount;
                    transactions.add(new Transaction(new Date(), "debit", amount,getBalance()));
                    return true;
                }else {
                    System.out.println("Can't overdraft more that 500");
                }
            }
        }

        return false;
    }

    public void overdraftRequest() {
        overdraftRequest = true;
    }

    public boolean getOverdraftRequest() {
        return overdraftRequest;
    }
    public void overdraftRequestApproved() {
         canBeOverdrafted = true;
        overdraftRequest = false;
    }
    public void overdraftRequestRejected() {
        canBeOverdrafted = false;
        overdraftRequest = false;
    }

    @Override
    public void generateBankStatement() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        List<Transaction> transactionsSortedByDate = this.transactions.stream().sorted(Comparator.comparing(Transaction::getDate).
                reversed()).collect(Collectors.toList());

        System.out.printf("%-10s || %-9s || %-9s || %4s %n", "date", "credit", "debit", "balance");
        for(Transaction transaction : transactionsSortedByDate) {
            String strDate = formatter.format(transaction.getDate());
            if(transaction.getTypeOfOperation().equals("credit")) {
                System.out.printf("%-10s || %-9s || %-9s || %1s %n", strDate, transaction.getAmount(), "", transaction.getBalance());
            }else {
                System.out.printf("%-10s || %-9s || %-9s || %1s %n", strDate, "", transaction.getAmount(), transaction.getBalance());
            }
        }
    }

    public String balanceCalculation() {
        double totalBalance = 0;
        if(transactions.isEmpty()) {
            return "0.00";
        }else {
            for(Transaction transaction : transactions) {
                if(transaction.getTypeOfOperation().equals("credit")) {
                    totalBalance += Double.valueOf(transaction.getAmount());
                }else if (transaction.getTypeOfOperation().equals("debit")) {
                    totalBalance -= Double.valueOf(transaction.getAmount());
                }

            }
            return String.format("%,.2f", totalBalance);
        }
    }


}
