package com.booleanuk.core;

import java.util.Collections;
import java.util.Random;
import java.util.SortedMap;

public abstract class Person {
    private String name;
    private int UID;

    public Person(String name, int UID) {
        this.setName(name);
        this.setUID(UID);
    }

    /**
     * Logic: Invoke method on instance of Person 'this', and specify which branch you want to create account at.
     * Uses helper method to ensure account number is unique.
     * @param branch
     * @return
     */
    public boolean createCurrentAccount(Branch branch) {
        try {
            CurrentAccount currentAccount = new CurrentAccount(branch, generateAccountNumber(branch), this, 0.0);
            branch.getCurrentAccounts().put(currentAccount.getAccountNumber(), currentAccount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Logic: Same as createCurrentAccount()
     * @param branch
     * @return
     */
    public boolean createSavingsAccount(Branch branch) {
        try {
            SavingsAccount savingsAccount = new SavingsAccount(branch, generateAccountNumber(branch), this, 0.0);
            branch.getSavingsAccounts().put(savingsAccount.getAccountNumber(), savingsAccount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Logic: Invoke method on instance of Person 'this', and specify which branch you want the statements from.
     * The same instance of Person can have multiple accounts like IRL, thus it will make a statement of Transactions for each
     * associated account. It utilizes the member variables associated with the branch to authenticate the statements.
     * @param b
     * @return
     */
    public boolean generateBankStatement(Branch b) {
        try {
            for(Account account : b.getCurrentAccounts().values()) {
                if(account.getAccountOwner() == this) {
                    System.out.println("Transaction History for [current account]");
                    System.out.println("[accountnumber]: " + account.getAccountNumber());
                    System.out.println("[accountowner_UID]: " + account.getAccountOwner().getUID());
                    System.out.println("[accountowner_name]: " + account.getAccountOwner().getName());
                    System.out.printf("%-11s|| %-9s|| %-8s|| %-8s%n", "date", "credit", "debit", "balance");
                    Collections.reverse(account.getTransactionHistory());
                    for(Transaction t : account.getTransactionHistory()) {
                        System.out.printf("%-11s|| %9s|| %8s|| %8.2f%n", t.getDate(), t.getCredit() == 0.0 ? "" : String.valueOf(t.getCredit()), t.getDebit() == 0.0 ? "" : String.valueOf(t.getDebit()), t.getBalance());
                    }
                }
                System.out.println("**Transaction Statement was made by**");
                System.out.println("[Bank]: " + b.getName());
                System.out.println("[Location]: " + b.getLocation());
                System.out.println("[Branch]: " + b.getBranchID());
                System.out.println("[Managed by]: " + b.getManager().getName());
                System.out.println();
            }

            for(Account account : b.getSavingsAccounts().values()) {
                if(account.getAccountOwner() == this) {
                    System.out.println("Transaction History for [savings account]");
                    System.out.println("[accountnumber]: " + account.getAccountNumber());
                    System.out.println("[accountowner_UID]: " + account.getAccountOwner().getUID());
                    System.out.println("[accountowner_name]: " + account.getAccountOwner().getName());
                    System.out.printf("%-11s|| %-9s|| %-8s|| %-8s%n", "date", "credit", "debit", "balance");
                    Collections.reverse(account.getTransactionHistory());
                    for(Transaction t : account.getTransactionHistory()) {
                        System.out.printf("%-11s|| %9s|| %8s|| %8.2f%n", t.getDate(), t.getCredit() == 0.0 ? "" : String.valueOf(t.getCredit()), t.getDebit() == 0.0 ? "" : String.valueOf(t.getDebit()), t.getBalance());
                    }
                }
                System.out.println("Transaction Statement was made by:");
                System.out.println("Bank: " + b.getName());
                System.out.println("Location: " + b.getLocation());
                System.out.println("Branch: " + b.getBranchID());
                System.out.println("Managed by: " + b.getManager().getName());
                System.out.println();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Logic: Invoke method on instance of Person 'this', and specify which branch you want to deposit money to,
     * which account (as the same instance of Person can have multiple accounts with unique account numbers),
     * and the value you want to deposit.
     *
     * It updates the balance of said instance of Account, if deposit is returns true.
     * If trying to deposit to Account not owned by 'this', it rejects the deposit and returns false.
     * If trying to deposit to Account that does not exist, it rejects the deposit and returns false.
     * @param branch
     * @param accountNumber
     * @param value
     * @return
     */
    public boolean deposit(Branch branch, int accountNumber, double value) {
        Transaction t = new Transaction(value, 0, 1337);

        if (branch.getCurrentAccounts().containsKey(accountNumber)) {
            if (branch.getCurrentAccounts().get(accountNumber).getAccountOwner() == this) {
                branch.getCurrentAccounts().get(accountNumber).setBalance(branch.getCurrentAccounts().get(accountNumber).getBalance() + value);
                t.setBalance(branch.getCurrentAccounts().get(accountNumber).getBalance());
                branch.getCurrentAccounts().get(accountNumber).getTransactionHistory().add(t);
                System.out.println(value + " has been deposited to account number: " + accountNumber);
                return true;
            } else {
                System.out.println("You do not have permission to deposit money to this account!");
                return false;
            }
        } else if (branch.getSavingsAccounts().containsKey(accountNumber)) {
            if (branch.getSavingsAccounts().get(accountNumber).getAccountOwner() == this) {
                branch.getSavingsAccounts().get(accountNumber).setBalance(branch.getSavingsAccounts().get(accountNumber).getBalance() + value);
                t.setBalance(branch.getSavingsAccounts().get(accountNumber).getBalance());
                branch.getSavingsAccounts().get(accountNumber).getTransactionHistory().add(t);
                System.out.println(value + " has been deposited to account number: " + accountNumber);
                return true;
            } else {
                System.out.println("You do not have permission to deposit money to this account!");
                return false;
            }
        } else {
            System.out.println("No such account exists!");
            return false;
        }
    }

    /**
     * Logic: Same logic as above.
     * Additionally, it checks if the value to be withdrawn would make the Account.balance() < 0, if true, return false.
     * Furthermore, it prevents withdrawing any value from an instance of a SavingsAccount!
     * @param branch
     * @param accountNumber
     * @param value
     * @return
     */
    public boolean withdraw(Branch branch, int accountNumber, double value) {
        Transaction t = new Transaction(0, value, 1337);

        if (branch.getCurrentAccounts().containsKey(accountNumber)) {
            if (branch.getCurrentAccounts().get(accountNumber).getAccountOwner() == this) {
                if ((branch.getCurrentAccounts().get(accountNumber).getBalance() - value) > 0) {
                branch.getCurrentAccounts().get(accountNumber).setBalance(branch.getCurrentAccounts().get(accountNumber).getBalance() - value);
                t.setBalance(branch.getCurrentAccounts().get(accountNumber).getBalance());
                branch.getCurrentAccounts().get(accountNumber).getTransactionHistory().add(t);
                System.out.println("APPROVED! " + value + " has been withdrawn from account number: " + accountNumber);
                return true;
                } else {
                    System.out.println("DENIED! The maximum you can withdraw from accountnumber: " + accountNumber + " is " + branch.getCurrentAccounts().get(accountNumber).getBalance() + " to prevent overdraw!");
                    return false;
                }
            } else {
                System.out.println("You do not have permission to withdraw money from this account!");
                return false;
            }
        } else if (branch.getSavingsAccounts().containsKey(accountNumber)) {
            if (branch.getSavingsAccounts().get(accountNumber).getAccountOwner() == this) {
                System.out.println("You are not currently allowed to conduct withdrawals from your savings accounts!");
            } else {
                System.out.println("You do not have permission to withdraw money from this account!");
            }
            return false;
        } else {
            System.out.println("No such account exists!");
            return false;
        }
    }

    /**
     * Logic: Helper method to prevent multiple instances of Account's with same account number at same branch.
     * Ideally, we would want to allow same account number at different branches by adding the branches unique ID
     * in front of the account number. Did not manage to do this in time.
     * @param branch
     * @return
     */
    public int generateAccountNumber(Branch branch) {
        Random random = new Random(123);
        int accountNumber = 0;
        do {
            accountNumber = random.nextInt(10000000, 100000000);
        } while (branch.getCurrentAccounts().containsKey(accountNumber) || branch.getSavingsAccounts().containsKey(accountNumber));
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int ID) {
        this.UID = ID;
    }
}
