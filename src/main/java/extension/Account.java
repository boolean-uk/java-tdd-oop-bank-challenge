package extension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    protected String firstname;
    protected String lastname;
    protected int currentBalance; // Balance in cents (int)
    public boolean activated;

    public ArrayList<Integer> balanceHistory;
    public ArrayList<String> dateHistory;
    public ArrayList<Double> balanceMoveHistory;
    String branch;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentBalance = 0;
        this.activated = false;

        this.balanceHistory = new ArrayList<>();
        this.dateHistory = new ArrayList<>();
        this.balanceMoveHistory = new ArrayList<>();
    }

    // Extension user story:
    // As a bank manager,
    // So I can expand,
    // I want accounts to be associated with specific branches.
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public boolean deposit(double balance) {
        if (balance <= 0) {
            return false;
        }

        this.activated = true;
        this.currentBalance += doubleToIntBalance(balance);
        this.balanceHistory.add(this.currentBalance);
        this.balanceMoveHistory.add(balance);
        this.dateHistory.add(getCurrentDate());
        return true;
    }

    public boolean withdraw(double balance) {
        if (doubleToIntBalance(balance) > this.currentBalance) {
            return false;
        }

        this.currentBalance -= doubleToIntBalance(balance);
        this.balanceHistory.add(this.currentBalance);
        this.balanceMoveHistory.add(-balance);
        this.dateHistory.add(getCurrentDate());
        return true;
    }

    int doubleToIntBalance(double balance) {
        return (int) (balance * 100);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public double getCurrentBalance() {
        if (balanceHistory.isEmpty()) {
            return 0.0;
        }
        return balanceHistory.get(balanceHistory.size()-1) / 100.0; // Updated to handle negative balances
    }

    public int getCurrentBalanceInCents() {
        if (balanceHistory.isEmpty()) {
            return 0;
        }
        return balanceHistory.get(balanceHistory.size()-1);
    }

    public String getLastname() {
        return this.lastname;
    }

    public boolean isActivated() {
        return this.activated;
    }

    protected String getCurrentDate() {
        LocalDate date = LocalDate.now();
        return DATE_FORMATTER.format(date);
    }
}
