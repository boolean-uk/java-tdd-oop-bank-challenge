package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestBankApp {
    @Test
    public void testUserStories() {
        CurrentAccount currentAccount = new CurrentAccount("12345");
        SavingsAccount savingsAccount = new SavingsAccount("67890");

        currentAccount.deposit(1000);
        currentAccount.withdraw(200);

        savingsAccount.deposit(500);
        savingsAccount.withdraw(100);

        BankStatement statement1 = new BankStatement("STMT001", currentAccount.getAccountNumber());
        statement1.addTransaction(new Transaction("T001", new Date(), 1000));
        statement1.addTransaction(new Transaction("T002", new Date(), 2000));
        statement1.addTransaction(new Transaction("T003", new Date(), -500));

        BankStatement statement2 = new BankStatement("STMT002", savingsAccount.getAccountNumber());
        statement2.addTransaction(new Transaction("T004", new Date(), 500));
        statement2.addTransaction(new Transaction("T005", new Date(), -100));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Current Account Statement:");
        statement1.generateStatement(sdf);

        System.out.println("\nSavings Account Statement:");
        statement2.generateStatement(sdf);

        Branch branch1 = new Branch("B001");
        branch1.addAccount(currentAccount);
        branch1.addAccount(savingsAccount);

        OverdraftRequest overdraftRequest = new OverdraftRequest("OR001", currentAccount.getAccountNumber(), 500);
        overdraftRequest.updateStatus("approved");

        PhoneMessage phoneMessage = new PhoneMessage("MSG001", "1234567890", "Your bank statement is ready.");

        phoneMessage.sendMessage();
    }
}