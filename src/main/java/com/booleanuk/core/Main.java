package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Branch osloBranch = new Branch("Oslo");
        Branch trondheimBranch = new Branch("Trondheim");
        Customer customer = new Customer("Melvin", "Seelan");
        CurrentAccount currentAccount = new CurrentAccount(500, osloBranch);
        SavingAccount savingAccount = new SavingAccount(1000, 2.5, trondheimBranch);
        customer.addAccount(currentAccount);
        //customer.addAccount(savingAccount);
        currentAccount.withdraw(100);
        currentAccount.requestOverdraft(300);
        currentAccount.approveOverdraft(300);
        currentAccount.withdraw(700);



        //currentAccount.rejectOverdraft();
        //System.out.println("Withdrawal Result with Overdraft: " + currentAccount.withdraw(600));
        //System.out.println("Current Account Balance: " + currentAccount.getBalance());
        //System.out.println("Saving Account Balance: " + savingAccount.getBalance());
        //System.out.println("Current Account Branch: " + currentAccount.getBranch());
        //System.out.println("Saving Account Branch: " + savingAccount.getBranch());
        //savingAccount.applyInterest();
        //savingAccount.withdraw(400);
    }
}
