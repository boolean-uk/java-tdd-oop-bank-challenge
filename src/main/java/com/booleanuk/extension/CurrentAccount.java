package com.booleanuk.extension;

public class CurrentAccount extends Account {

    String type = "Current";
    Boolean overDraftAbility = false;

    public CurrentAccount(String firstname, String lastname) {
        super(firstname, lastname);
    }

    // Extension user story:
    // As a customer,
    // So I have an emergency fund,
    // I want to be able to request an overdraft on my account.
    public Boolean getOverDraftAbility() {
        return overDraftAbility;
    }

    public void setOverDraftAbility(Boolean overDraftAbility) {
        this.overDraftAbility = overDraftAbility;
    }

    // Extension user story:
    // As an engineer,
    // So I don't need to keep track of state,
    // I want account balances to be calculated based on transaction history instead of stored in memory.
    @Override
    public boolean withdraw(double balance) {
        int balanceInCents = doubleToIntBalance(balance);
        int currentBalanceInCents = balanceHistory.get(balanceHistory.size()-1);

        if (balanceInCents > currentBalanceInCents) {
            if (overDraftAbility) {
                System.out.println("Your overdraft was accepted!");
                balanceHistory.add(currentBalanceInCents - balanceInCents);  // Updated to allow negative balances
                balanceMoveHistory.add(-balance);
                dateHistory.add(getCurrentDate());
                return true;
            }
            System.out.println("Cant withdraw more than your current balance");
            return false;
        }
        balanceHistory.add(currentBalanceInCents - balanceInCents);
        balanceMoveHistory.add(-balance);
        dateHistory.add(getCurrentDate());
        return true;
    }

}
