package extension;

import core.Account;

public class SavingAccount extends Account {
    String type = "Savings";
    public SavingAccount(String firstname, String lastname) {
        super(firstname, lastname);
    }
}