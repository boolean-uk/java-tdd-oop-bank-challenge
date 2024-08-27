package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static com.booleanuk.core.NumberUtils.*;

public class CustomerTest {

    //Core requirements
    //
    // User story 1: Create a current account
    @Test
    public void openCurrentAccount(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);

        Assertions.assertEquals("Opened a new current account: 'Test Current'.",
                customer.openCurrentAccount("Test Current", Branch.Bergen));
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    // User story 2: Create a savings account
    @Test
    public void openSavingsAccount(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);

        Assertions.assertEquals("Opened a new savings account: 'Test Savings'.",
                customer.openSavingsAccount("Test Savings", Branch.Trondheim));
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    // User story 3: Generate bank statement
    @Test
    public void customersBankStatement(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openCurrentAccount("CurrentAccountTest", Branch.Trondheim);
        Account account = customer.getAccount("CurrentAccountTest");
        account.deposit(50);
        account.deposit(30);
        account.deposit(20);
        account.withdraw(40);
        account.generateBankStatement();
        account.printBankStatement();
        // Remember to change date when testing
        String bankStatement =
                "[Date        ||     Amount ||     Balance, " +
                "----------------------------------------, " +
                "27/08/2024  ||     50.00£ ||      50.00£, " +
                "27/08/2024  ||     30.00£ ||      80.00£, " +
                "27/08/2024  ||     20.00£ ||     100.00£, " +
                "27/08/2024  ||    -40.00£ ||      60.00£]";

        Assertions.assertEquals(bankStatement, account.getBankStatement().toString());
    }

    // User story 4: Deposit funds
    @Test
    public void customerDepositFunds(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openSavingsAccount("Test Savings", Branch.Bergen);
        Account account = customer.getAccount("Test Savings");
        account.deposit(267.96f);
        account.deposit(793.23f);

        Assertions.assertEquals(floatFormatter(1061.19f), floatFormatter(centsToPounds(account.getBalanceInCents())));
    }


    // User story 4: Withdraw funds
    @Test
    public void customerWithdrawFunds(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openSavingsAccount("Test Savings", Branch.Oslo);
        Account account = customer.getAccount("Test Savings");
        account.deposit(250f);

        Assertions.assertEquals("Funds withdrawn from account.", account.withdraw(55f));
        Assertions.assertEquals(floatFormatter(195f), floatFormatter(centsToPounds(account.getBalanceInCents())));

    }

    //Extension requirements
    //
    // User story 3: Request overdraft on account
    @Test
    public void canCustomerRequestOverdraft(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openCurrentAccount("Test Current", Branch.Oslo);
        CurrentAccount account = (CurrentAccount) customer.getAccount("Test Current");
        account.deposit(250f);

        account.requestOverdraft();
        Assertions.assertTrue(account.getOverdraftRequestPending());
    }

    @Test
    public void canCustomerOverdraft(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openCurrentAccount("Test Savings", Branch.Oslo);
        CurrentAccount account = (CurrentAccount) customer.getAccount("Test Savings");
        account.deposit(250f);

        account.requestOverdraft();
        Manager manager = new Manager(Branch.Oslo);
        manager.approveOverdraftRequest(account);

        account.withdraw(1200f);
        Assertions.assertEquals(floatFormatter(-950.00f), floatFormatter(centsToPounds(account.getBalanceInCents())));

    }

}
