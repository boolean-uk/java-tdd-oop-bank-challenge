package com.booleanuk.core;

import java.rmi.server.UID;
import java.util.Random;

public class Customer extends Person {
    private CreditScore creditScore;
    public Customer(String name, int UID) {
        super(name, UID);
        this.setCreditScore(CreditScore.FAIR);
    }

    /**
     * Logic: Can be invoked on an instance 'this' of Customer class, to specify which of its accounts needs overdraft.
     * The behaviour depends on the value of this.creditScore. Firstly it uses helper method to the requesting instance is equal to
     * the owner of the account.
     * @param branch
     * @param accountNumber
     * @param value
     * @return
     */
    public boolean requestOverdraft(Branch branch, int accountNumber, int value) {
        CurrentAccount account = (CurrentAccount) branch.getCurrentAccounts().get(accountNumber);
        Person owner = branch.getCurrentAccounts().get(accountNumber).getAccountOwner();
        if (!checkAccountBelongsToPerson(owner, this)) {
            System.out.println("You don't have permission to request overdraft on this [current account]");
            return false;
        }
        switch (this.getCreditScore()) {
            case EXCELLENT:
                System.out.println("Overdraft approved!");
                account.setAllowed_overdraft(value);
                break;
            case GOOD:
                System.out.println("After thorough consideration, overdraft was approved!");
                account.setAllowed_overdraft(value);
                break;
            case FAIR:
                System.out.println("Unfortunately, the overdraft was denied! Your CreditScore is too low!");
                return false;
            case POOR:
                System.out.println("No way you're getting an overdraft! Your CreditScore is too low!");
                return false;
            default:
                System.out.println("Unknown credit score. KEK");
        }
        return true;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

}
