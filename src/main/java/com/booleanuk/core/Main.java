package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void approveOverdraftRequest(Scanner scanner, Account account) {
        if (account instanceof CurrentAccount) {
            ((CurrentAccount) account).approveOverdraftRequest();
        } else {
            System.out.println("Overdraft requests are only applicable to current accounts.");
        }
    }

    private static void rejectOverdraftRequest(Scanner scanner, Account account) {
        if (account instanceof CurrentAccount) {
            ((CurrentAccount) account).rejectOverdraftRequest();
        } else {
            System.out.println("Overdraft requests are only applicable to current accounts.");
        }
    }

    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        Branch mainBranch = new Branch("Main Branch");
        bankManager.addBranch(mainBranch);

        Client client1 = new Client("John Doe", "12345");
        Client client2 = new Client("Jane Smith", "67890");

        bankManager.addClient(client1);
        bankManager.addClient(client2);

        Account currentAccount1 = new CurrentAccount("C123456", client1);
        Account savingsAccount1 = new SavingsAccount("S987654", client1);

        mainBranch.addAccount(currentAccount1);
        mainBranch.addAccount(savingsAccount1);

        currentAccount1.deposit(new BigDecimal("1000"));
        currentAccount1.withdraw(new BigDecimal("100"));

        savingsAccount1.deposit(new BigDecimal("2000"));
        currentAccount1.setOverdraftLimit(new BigDecimal("500"));
        currentAccount1.requestOverdraft(new BigDecimal("200"));

        System.out.println("Are you a client or a manager?");
        System.out.println("1. Client");
        System.out.println("2. Manager");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String selectedClientId = null;
        Branch selectedBranch = null;

        try {
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                List<Client> clients = bankManager.getClients();
                System.out.println("\nClients in bank:");
                for (Client client : clients) {
                    System.out.println("Client id: " + client.getClientId() + ", Name: " + client.getName());
                }

                System.out.println("\nChoose client id: ");
                selectedClientId = scanner.nextLine();

                Client selectedClient = null;
                for (Client client : clients) {
                    if (client.getClientId().equals(selectedClientId)) {
                        selectedClient = client;
                        break;
                    }
                }

                if (selectedClient != null) {
                    System.out.println("\nInformation about accounts for " + selectedClient.getName() + ":");

                    for (Account account : mainBranch.getAccounts()) {
                        if (account.getClient().getClientId().equals(selectedClientId)) {
                            if (account instanceof CurrentAccount) {
                                System.out.println("Current account: " + account.getAccountNumber() + ", Total: " + account.getBalance());
                                // Check if the account has a pending overdraft request
                                if (((CurrentAccount) account).isOverdraftRequestPending()) {
                                    System.out.println("Overdraft Request: Pending");
                                } else {
                                    System.out.println("Overdraft Request: Not Pending");
                                }
                            } else if (account instanceof SavingsAccount) {
                                System.out.println("\nSavings account: " + account.getAccountNumber() + ", Total: " + account.getBalance());
                            }

                            System.out.println("Account Statement:");
                            BankStatement bankStatement = new BankStatement();
                            bankStatement.printStatement(account);
                        }
                    }
                } else {
                    System.out.println("No client with this id was found.");
                }
            } else if (choice == 2) {
                System.out.println("\nBranches in bank:");
                List<Branch> branches = bankManager.getBranches();
                for (int i = 0; i < branches.size(); i++) {
                    System.out.println(i + 1 + ". " + branches.get(i).getBranchName());
                }

                System.out.println("\nChoose number of branch: ");
                int selectedBranchIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedBranchIndex > 0 && selectedBranchIndex <= branches.size()) {
                    selectedBranch = branches.get(selectedBranchIndex - 1);
                } else {
                    System.out.println("Incorrect choice of branch!");
                    scanner.close();
                    return;
                }
                System.out.println("3. Review Overdraft Requests (input '3') : ");

                int managerChoice = scanner.nextInt();
                scanner.nextLine();

                switch (managerChoice) {
                    case 3:
                        System.out.println("Accounts requesting overdraft approval:");
                        for (Account account : mainBranch.getAccounts()) {
                            if (account instanceof CurrentAccount && ((CurrentAccount) account).isOverdraftRequestPending()) {
                                System.out.println(account.getAccountNumber());
                            }
                        }
                        System.out.println("\nChoose an account number to review:");
                        String selectedAccountNumber = scanner.nextLine();
                        Account selectedAccount = null;
                        for (Account account : mainBranch.getAccounts()) {
                            if (account.getAccountNumber().equals(selectedAccountNumber)) {
                                selectedAccount = account;
                                break;
                            }
                        }

                        if (selectedAccount != null) {
                            System.out.println("\nSelected account: " + selectedAccount.getAccountNumber());
                            System.out.println("Do you want to approve or reject the overdraft request?");
                            System.out.println("1. Approve");
                            System.out.println("2. Reject");

                            int approvalChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (approvalChoice) {
                                case 1:
                                    approveOverdraftRequest(scanner, selectedAccount);
                                    break;
                                case 2:
                                    rejectOverdraftRequest(scanner, selectedAccount);
                                    break;
                                default:
                                    System.out.println("Invalid choice. The overdraft request remains pending.");
                                    break;
                            }
                        } else {
                            System.out.println("No account with this number was found.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice for the manager.");
                        scanner.close();
                        return;
                }
            } else {
                System.out.println("Incorrect choice!");
                scanner.close();
                return;
            }

            if (selectedBranch != null) {
                System.out.println("\nSelected branch: " + selectedBranch.getBranchName());
                System.out.println("\nEnter account number: ");
                String newAccountNumber = scanner.nextLine();
                System.out.println("\nEnter client id: ");
                String clientIdForNewAccount = scanner.nextLine();

                Client existingClient = bankManager.getClientById(clientIdForNewAccount);
                if (existingClient != null) {
                    if (newAccountNumber.startsWith("C")) {
                        Account newAccount = new CurrentAccount(newAccountNumber, existingClient);
                        selectedBranch.addAccount(newAccount);
                        System.out.println("Added current account to the branch: " + selectedBranch.getBranchName());
                    } else if (newAccountNumber.startsWith("S")) {
                        Account newAccount = new SavingsAccount(newAccountNumber, existingClient);
                        selectedBranch.addAccount(newAccount);
                        System.out.println("Added saving account to the branch: " + selectedBranch.getBranchName());
                    } else {
                        System.out.println("Incorrect account!");
                    }
                } else {
                    System.out.println("No client with this id was found.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input. Choose 1 or 2");
        } finally {
            scanner.close();
        }

        mainBranch.removeAccount(currentAccount1);
        mainBranch.removeAccount(savingsAccount1);
        bankManager.removeBranch(mainBranch);
    }
}