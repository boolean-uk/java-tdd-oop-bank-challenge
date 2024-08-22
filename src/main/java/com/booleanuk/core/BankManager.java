package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;
import com.migzus.terminal.menus.Menu;
import com.migzus.terminal.menus.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {
    // this class is not supposed to represent an actual bank. It is more of a helper class for menu callbacks to the accounts
    public final ArrayList<Account> accounts = new ArrayList<>();
    public int targetAccount = 0;

    protected final ArrayList<Integer> accountOverdraftRequests = new ArrayList<>();

    public void createNewAccount() {
        Menu _accountTypes = new Menu("Select the Account you want");

        _accountTypes.pushButton(new Button("Savings Account", new Callable(this, "setPendingAccountCreation", AccountType.SAVINGS_ACCOUNT)));
        _accountTypes.pushButton(new Button("Current Account", new Callable(this, "setPendingAccountCreation", AccountType.CURRENT_ACCOUNT)));
        _accountTypes.pushButton(new Button("Cancel", new Callable(_accountTypes, "unfocus")));

        _accountTypes.focus();
    }

    public void setPendingAccountCreation(final AccountType type) {
        Menu.clearScreen();

        System.out.println("Write account name:");
        Scanner _scanner = new Scanner(System.in);

        String _name = _scanner.nextLine();

        switch (type) {
            case CURRENT_ACCOUNT -> accounts.add(new CurrentAccount(_name, 100000.0));
            case SAVINGS_ACCOUNT -> accounts.add(new SavingsAccount(_name, 1000000.0));
        }

        Menu.currentActiveMenu.unfocus();
    }

    public void transactionsMenu(int targetAccount) {
        this.targetAccount = targetAccount;

        Menu _bankAccountActions = new Menu(accounts.get(targetAccount).accountName);

        _bankAccountActions.onFocus = new Callable(this, "printCurrentBalance");

        _bankAccountActions.pushButton(new Button("Deposit", new Callable(this, "depositCallback")));
        _bankAccountActions.pushButton(new Button("Withdraw", new Callable(this, "withdrawCallback")));

        _bankAccountActions.pushWhitespace();
        _bankAccountActions.pushButton(new Button("Bank Statement", new Callable(this, "printBankStatement")));

        if (!accounts.get(targetAccount).isOverdraft)
            _bankAccountActions.pushButton(new Button("Request Overdraft for this account", new Callable(this, "requestOverdraft")));
        _bankAccountActions.pushButton(new Button("Return", new Callable(_bankAccountActions, "unfocus")));

        _bankAccountActions.focus();
    }

    public void requestOverdraft() {
        if (!accountOverdraftRequests.contains(targetAccount)) {
            System.out.println("Overdraft request sent!");
            accountOverdraftRequests.add(targetAccount);
        }
        else
            System.out.println("Overdraft request is already pending for this account. Please wait for approval.");
    }

    public void accountOverview() {
        Menu _accounts = new Menu("Your Accounts");
        _accounts.onPreMenuPrint = new Callable(this, "repopulateAccountMenu", _accounts);
        _accounts.focus();
    }

    public void repopulateAccountMenu(final Menu accountMenu) {
        accountMenu.clearButtons();

        for (int i = 0; i < accounts.size(); i++)
            accountMenu.pushButton(new Button(accounts.get(i).accountName, new Callable(this, "transactionsMenu", i)));

        accountMenu.pushWhitespace();
        accountMenu.pushButton(new Button("Create a new Account", new Callable(this, "createNewAccount")));
        accountMenu.pushButton(new Button("Return", new Callable(accountMenu, "unfocus")));
    }

    public void bankManagement() {
        Menu _manager = new Menu("Welcome Owner, Today's Requests");
        _manager.onPreMenuPrint = new Callable(this, "populateBankManagementMenu", _manager);
        _manager.focus();
    }

    public void populateBankManagementMenu(final Menu manager) {
        manager.clearButtons();

        for (int accountIndex : accountOverdraftRequests)
            manager.pushButton(new Button(accounts.get(accountIndex).accountName + " Requests an Overdraft", new Callable(this, "handleRequest", accountIndex)));

        manager.pushWhitespace();
        manager.pushButton(new Button("Return", new Callable(manager, "unfocus")));
    }

    public void handleRequest(final int accountIndex) {
        Menu _requestHandle = new Menu("Handle Request");

        _requestHandle.pushButton(new Button("Accept", new Callable(this, "tellRequest", accountIndex, true)));
        _requestHandle.pushButton(new Button("Reject", new Callable(this, "tellRequest", accountIndex, false)));
        _requestHandle.pushButton(new Button("Ignore", new Callable(_requestHandle, "unfocus")));

        _requestHandle.focus();
    }

    public void tellRequest(final int accountIndex, final boolean accepted) {
        if (accepted)
            accounts.get(accountIndex).isOverdraft = true;
        accountOverdraftRequests.remove(accountIndex);

        Menu.currentActiveMenu.unfocus();
    }

    public void depositCallback() {
        System.out.println("Deposit an amount:");
        Scanner _scanner = new Scanner(System.in);
        double _credit;

        try {
            _credit = Double.parseDouble(_scanner.next());
        }
        catch (Exception e) {
            System.out.println("'" + _scanner.next() + "' is not a valid number! Only accepted inputs are numbers above 0.");
            return;
        }

        switch (accounts.get(targetAccount).deposit(_credit)) {
            case OK -> System.out.println("Successfully added £" + _credit + " to your account.");
            case ERROR -> System.out.println("A generic error has occurred.");
            case INVALID_NUMBER -> System.out.println("The number '" + _credit + "' is invalid! Aborting...");
            case EXCEEDED_BALANCE -> System.out.println("With this transaction you will exceed your current account limit! Skipping.");
        }
    }

    public void withdrawCallback() {
        System.out.println("Withdrawal an amount:");
        Scanner _scanner = new Scanner(System.in);
        double _debit;

        try {
            _debit = Double.parseDouble(_scanner.next());
        }
        catch (Exception e) {
            System.out.println("'" + _scanner.next() + "' is not a valid number! Only accepted inputs are numbers above 0.");
            return;
        }

        switch (accounts.get(targetAccount).withdraw(_debit)) {
            case OK -> System.out.println("Successfully added £" + _debit + " to your account.");
            case ERROR -> System.out.println("A generic error has occurred.");
            case EXCEEDED_WITHDRAWAL_AMOUNT -> System.out.println("You have just exceeded your monthly withdrawal amount. Contact us for support.");
            case BALANCE_TOO_SMALL -> System.out.println("With this transaction you will go below 0 in balance. Skipping.");
            case INVALID_NUMBER -> System.out.println("The number '" + _debit + "' is invalid! Aborting...");
        }
    }

    public void printBankStatement() {
        TransactionStatement[] _tStatements = accounts.get(targetAccount).getBankStatement();
        Table _table = new Table();

        _table.pushColumn("Transaction Date");
        _table.pushColumn("Deposit");
        _table.pushColumn("Debit");
        _table.pushColumn("Balance");

        for (TransactionStatement ts : _tStatements) {
            switch (ts.type()) {
                case DEPOSIT -> _table.pushRow(ts.date(), "£" + ts.credit(), "", "£" + ts.balance());
                case WITHDRAW -> _table.pushRow(ts.date(), "", "£" + ts.credit(), "£" + ts.balance());
            }
        }

        System.out.println("\n" + _table);
    }

    public void printCurrentBalance() {
        System.out.println("\tTotal Balance £" + accounts.get(targetAccount).getBalance() + "\n");
    }
}
