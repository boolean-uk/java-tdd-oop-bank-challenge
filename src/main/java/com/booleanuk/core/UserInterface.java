package com.booleanuk.core;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        BankBranch bank = new BankBranch();
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("Welcome to our Bank!");
        System.out.println("You don't own any account in our Bank yet.");
        System.out.println("Do you wish to create one?");
        System.out.println("1. Create current account");
        System.out.println("2. Create savings account ");
        System.out.println("Please press 1 or 2 and press Enter to create an account");
        System.out.println("");
        int intInput = sc.nextInt();
        int bankAccountNumber;
        boolean isCurrentAccount = false;
        if (intInput == 1) {
            isCurrentAccount = true;
        }
        bankAccountNumber = bank.createAccount(isCurrentAccount);

        System.out.println("");
        System.out.println("Thank you for creating an account in our bank!");
        System.out.println("Your new account number is: " + bankAccountNumber);
        System.out.println("You can now deposit a first sum on your account!");
        System.out.println("Please provide an amount:");
        System.out.println("");
        double doubleInput = sc.nextDouble();
        bank.depositMoney(bankAccountNumber, doubleInput);
        System.out.println("");
        System.out.println("Congratulations on depositing a first sum on your account!");
        System.out.println("");
        
        while(intInput != 5) {
            System.out.println("What do you wish to do next?");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Generate bank statement");
            System.out.println("4. Request overdraft");
            System.out.println("5. Exit the bank system");
            System.out.println("Please press a number and press Enter");
            System.out.println("");
            intInput = sc.nextInt();
            System.out.println("");
            if (intInput == 1) {
                System.out.println("Please provide an amount:");
                System.out.println("");
                doubleInput = sc.nextDouble();
                bank.depositMoney(bankAccountNumber, doubleInput);
                System.out.println("");
                System.out.println("You successfully deposited: " + doubleInput);
                System.out.println("");
            } else if (intInput == 2) {
                System.out.println("Please provide an amount:");
                System.out.println("");
                doubleInput = sc.nextDouble();
                bank.withdrawMoney(bankAccountNumber, doubleInput);
                System.out.println("");
                System.out.println("Please take withdrawn money: " + doubleInput);
                System.out.println("");
            } else if (intInput == 3) {
                System.out.println(bank.getBankStatement(bankAccountNumber));
                System.out.println("");
            } else if (intInput == 4) {
                if(isCurrentAccount) {
                    System.out.println("Please provide an amount:");
                    System.out.println("");
                    doubleInput = sc.nextDouble();
                    bank.requestOverdraft(bankAccountNumber, doubleInput);
                    System.out.println("");
                    System.out.println("Your overdraft is now: " + doubleInput);
                    System.out.println("");
                } else {
                    System.out.println("Sorry, you can't have an overdraft on a savings account");
                    System.out.println("");
                }
            }
        }
    }
}
