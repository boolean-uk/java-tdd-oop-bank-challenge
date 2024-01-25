package com.booleanuk.extension;

public class Customer {
    private Account savingsAccount;
    private Account currentAccount;

    public Customer() {
    }

    public boolean createAccount(String type){
        if (type.equalsIgnoreCase("Savings")){
            savingsAccount = new SavingsAccount();
            return true;
        } else if (type.equalsIgnoreCase("Current")){
            currentAccount = new CurrentAccount();
            return true;
        }
        System.out.println("Invalid account type");
        return false;
    }

    public boolean deposit(Account account, double amount){
        if(amount < 0){
            return false;
        }
        account.add(amount);
        return true;

    }

    public boolean withdraw(Account account, double amount){
        if(amount > account.getBalance() || amount < 0){
            return false;
        }
        account.remove(amount);
        return true;
    }

    public String generateBankStatement(Account account){

        StringBuilder res = new StringBuilder();

        res.append("| ").append(String.format("%-9s", "Date \t\t|"));
        res.append("| ").append(String.format("%-9s", "Transaction |"));
        res.append("| ").append(String.format("%-9s", "Balance |\n"));

        for(Transaction transaction : account.getTransactions()){

            res.append("| ").append(String.format("%-9s", transaction.getDate())).append(" |");
            res.append("| ").append(String.format("%-9s", transaction.getAmount())).append(" |");
            res.append("| ").append(String.format("%-9s", transaction.getBalance())).append(" |\n");

        }

        return res.toString();
    }

    public boolean requestOverDraft(CurrentAccount account, double amount){
        return false;
    }
}
