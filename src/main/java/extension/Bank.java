package extension;

import core.Account;
import core.CurrentAccount;
import core.SavingAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private ArrayList<core.Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }


    public boolean createAccount(String firstname, String lastname) {
        if (accountExists(firstname, lastname, core.CurrentAccount.class)) {
            System.out.println("Failed to create an account. The user already has an account!");
            return false;
        }

        core.Account account = new CurrentAccount(firstname, lastname);
        accounts.add(account);
        System.out.println("New user created!");
        return true;
    }

    public boolean createAccount(String firstname, String lastname, String type) {
        Class<?> accountClass = type.equalsIgnoreCase("current") ? CurrentAccount.class : core.SavingAccount.class;
        if (accountExists(firstname, lastname, accountClass)) {
            System.out.println("Failed to create an account. The user already has a " + type + " account!");
            return false;
        }

        core.Account account = accountClass.equals(CurrentAccount.class)
                ? new CurrentAccount(firstname, lastname)
                : new SavingAccount(firstname, lastname);

        accounts.add(account);
        System.out.println("New user created!");
        return true;
    }

    public boolean printStatement(Account account) {
        if (!accounts.contains(account)) {
            System.out.println("Account does not exist!");
            return false;
        }

        if (!account.activated) {
            System.out.println("Account exists but is not activated and has no Statement yet.");
            return false;
        }

        printTransactionHistory(account);
        return true;
    }

    private void printTransactionHistory(Account account) {
        System.out.println("Date       || Credit   || Debit    || Balance");
        for (int i = account.balanceHistory.size() - 1; i >= 0; i--) {
            System.out.print(account.dateHistory.get(i) + " ||");
            printTransactionDetail(account.balanceMoveHistory.get(i));
            printCurrentBalance(account.balanceHistory.get(i));
        }
    }

    private void printTransactionDetail(Double balanceMove) {
        if (balanceMove > 0) {
            System.out.printf("%9s ||         ", DECIMAL_FORMAT.format(balanceMove));
        } else {
            System.out.printf("          ||%9s", DECIMAL_FORMAT.format(balanceMove));
        }
    }

    private void printCurrentBalance(Integer currentBalance) {
        double histBalance = currentBalance / 100.0;
        System.out.print(" || " + DECIMAL_FORMAT.format(histBalance));
        System.out.println();
    }

    private boolean accountExists(String firstname, String lastname, Class<?> accountClass) {
        return accounts.stream()
                .anyMatch(account -> firstname.equals(account.getFirstname())
                        && lastname.equals(account.getLastname())
                        && accountClass.equals(account.getClass()));
    }

}