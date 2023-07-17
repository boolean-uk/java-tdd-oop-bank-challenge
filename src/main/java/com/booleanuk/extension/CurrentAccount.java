package com.booleanuk.extension;

public class CurrentAccount extends Account {

    String type = "current";
    Boolean overDraftAbility = false;

    public CurrentAccount(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Boolean getOverDraftAbility() {
        return overDraftAbility;
    }

    public void setOverDraftAbility(Boolean overDraftAbility) {
        this.overDraftAbility = overDraftAbility;
    }

    @Override
    public boolean withdraw(double balance) {
        if (doubleToIntBalance(balance) > balanceHistory.get(balanceHistory.size()-1)) {

            if (overDraftAbility) {
                System.out.println("Your overdraft was accepted!");
                balanceHistory.add(balanceHistory.get(balanceHistory.size()-1) - doubleToIntBalance(balance));
                balanceMoveHistory.add(-balance);
                dateHistory.add(getDate());
                return true;
            }

            System.out.println("Cant withdraw more than your current balance");
            return false;
        }

        balanceHistory.add(balanceHistory.get(balanceHistory.size()-1) - doubleToIntBalance(balance));
        balanceMoveHistory.add(-balance);
        dateHistory.add(getDate());
        return true;
    }
}
