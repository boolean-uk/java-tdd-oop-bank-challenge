package com.booleanuk.core;

import java.util.ArrayList;
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
        System.out.println("How much money do you with to deposit?");
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
}
