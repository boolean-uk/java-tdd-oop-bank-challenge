package com.booleanuk.core;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add User");
        System.out.println("12. (For testing) Add starting data");

        return getInt();
    }

    public int getInt() {
        int output;
        try {
            output = scanner.nextInt();
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
}
