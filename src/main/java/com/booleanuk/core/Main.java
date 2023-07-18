package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int accountChoice;

        while (running) {
            try {
                printMenu();
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createCurrentAccount(accounts);
                        break;
                    case 2:
                        ceateSavingAccount(accounts);
                        break;
                    case 3:
                        System.out.println("Choose account to generate bank statement.");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println(i + ". " + accounts.get(i));
                        }
                        accountChoice = scanner.nextInt();
                        if (accountChoice >= 0 && accountChoice < accounts.size()) {
                            Account account = accounts.get(accountChoice);
                            account.generateStatement();
                            break;
                        }
                    case 4:
                        System.out.println("To which account you want to deposit money?");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println(i + ". " + accounts.get(i));
                        }
                        scanner.nextLine();
                        accountChoice = scanner.nextInt();
                        depositMoney(accounts, scanner, accountChoice);
                        break;
                    case 5:
                        System.out.println("From which account you want to withdraw money?");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println(i + ". " + accounts.get(i));
                        }
                        scanner.nextLine();
                        accountChoice = scanner.nextInt();
                        withdrawMoney(accounts, scanner, accountChoice);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exit program!");
                    default:
                        System.out.println("Wrong input! Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Please Select an option below:");
        System.out.println("1. Create current account. ");
        System.out.println("2. Create saving account.");
        System.out.println("3. Generate bank statements.");
        System.out.println("4. Deposit founds.");
        System.out.println("5. Withdraw founds.");
        System.out.println("0. Exit.");
    }

    private static void withdrawMoney(List<Account> accounts, Scanner scanner, int accountChoice) {
        if (accountChoice >= 0 && accountChoice < accounts.size()) {
            Account account = accounts.get(accountChoice);
            System.out.println("What amount of money do you want to withdraw?");
            scanner.nextLine();
            double amount = scanner.nextDouble();
            Transaction transaction = new Transaction(account);
            transaction.withdraw(amount);
            account.getTransactions().add(transaction);
        }
    }

    private static void depositMoney(List<Account> accounts, Scanner scanner, int accountChoice) {
        if (accountChoice >= 0 && accountChoice < accounts.size()) {
            Account account = accounts.get(accountChoice);
            System.out.println("What amount of money do you want to deposit?");
            scanner.nextLine();
            double amount = scanner.nextDouble();
            Transaction transaction = new Transaction(account);
            transaction.deposit(amount);
            account.getTransactions().add(transaction);
            System.out.println("You deposited " + amount);
            System.out.println("transactions size " + account.getTransactions().size());
        } else {
            System.out.println("Wrong input!");
        }
    }

    private static void ceateSavingAccount(List<Account> accounts) {
        SavingAccount savingAccount = new SavingAccount(BankBranch.PARIS1);
        accounts.add(savingAccount);
        System.out.println("Saving account created successfully");
    }

    private static void createCurrentAccount(List<Account> accounts) {
        CurrentAccount currentAccount = new CurrentAccount(BankBranch.LONDON1);
        accounts.add(currentAccount);
        System.out.println("Current account created successfully");
    }
}
