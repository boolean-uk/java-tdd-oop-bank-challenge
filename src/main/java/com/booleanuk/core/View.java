package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add User");
        System.out.println("2. Log in as User");
        System.out.println("3. Create account");
        System.out.println("4. Deposit");
        System.out.println("5. See balance");
        System.out.println("6. Withdraw");
        System.out.println("7. Transfer");
        System.out.println("8. Bank statement");
        System.out.println("12. (For testing) Add starting data");

        return getInt();
    }

    public int getInt() {
        int output;
        try {
            output = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Something went wrong");
            output = Integer.MIN_VALUE;
        }
        return output;
    }

    public User getUser(String userId) {
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        return new User(userId, name);
    }

    public void printUser(User user) {
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User name: " + user.getName());
        System.out.println("Account numbers: ");
        for (String str: user.getAccountNumbers()) {
            System.out.println("  " + str);
        }
    }

    public User chooseUser(ArrayList<User> users) {
        for (int i = 1; i <= users.size(); i++) {
            System.out.printf("%d. %s%n", i, users.get(i - 1).getName());
        }
        return users.get(getInt() - 1);
    }

    public Account getAccount(String ownerId, String accountId) {
        System.out.println("What branch should the account be made under (4 numbers, leave empty for 0000)?");
        String branchId = scanner.nextLine();
        if (branchId.isBlank()) {
            branchId = "0000";
        }
        System.out.println("What kind of Account do you want?");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = getInt();
        if (choice == 1) {
            return new SavingsAccount(ownerId, branchId, accountId);
        } else {
            return new CurrentAccount(ownerId, branchId, accountId);
        }
    }

    public int depositAmount() {
        System.out.println("How much money do you wish to deposit?");
        String amount = scanner.nextLine();
        amount = amount.replace(',', '.');
        return Math.round(Float.parseFloat(amount) * 100);
    }

    public int withdrawAmount() {
        System.out.println("How much money do you wish to withdraw?");
        String amount = scanner.nextLine();
        amount = amount.replace(',', '.');
        return Math.round(Float.parseFloat(amount) * 100);
    }

    public String chooseAccountNumber(ArrayList<String> accountNumbers) {
        System.out.println("Choose account:");
        for (int i = 1; i <= accountNumbers.size(); i++) {
            System.out.printf("%d. %s%n", i, accountNumbers.get(i - 1));
        }
        return accountNumbers.get(getInt() - 1);
    }

    public void printBalance(int balance) {
        System.out.printf("In this account you have %.2f money.%n", (float) balance / 100);
    }

    public void print(String str) {
        System.out.println(str);
    }

    public void notCurrentAccount() {
        System.out.println("To withdraw you need to use a current account.");
    }

    public Depositable chooseDepositable() {
        System.out.println("Choose an account to transfer to.\nAccount numbers:");
        List<String> keyset = Controller.depositables.keySet().stream().toList();
        for (int i = 1; i <= Controller.depositables.size(); i++) {
            System.out.printf("%d. %s%n", i, keyset.get(i - 1));
        }
        int choice = getInt();
        return Controller.depositables.get(keyset.get(choice - 1));
    }

    public void printBankStatement(ArrayList<Transaction> transactions, String accountNumber) {
        transactions.sort(Comparator.comparing(Transaction::transactionTime));
        System.out.println("date       || credit  || debit  || balance");
        for (Transaction t: transactions) {
            String date = formatDate(t.transactionTime());
            String credit = t.toAccount().equals(accountNumber) ? "      " : String.format("%.2f", (float) t.value() / 100);
            String debit = t.fromAccount().equals(accountNumber) ? "      " : String.format("%.2f", (float) t.value() / 100);
            int dayDif = (int) ChronoUnit.DAYS.between(LocalDateTime.now(), t.transactionTime());
            float displayMoney = (float) Account.calculateBalance(transactions, accountNumber, dayDif) / 100;
            System.out.printf("%s || %s || %s || %.2f%n", date, credit,debit, displayMoney);
        }
    }

    private String formatDate(LocalDateTime t) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyy");
        return t.format(f);
    }
}
