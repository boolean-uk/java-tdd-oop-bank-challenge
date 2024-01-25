package com.booleanuk.core;

public class Main {

    /**
     * (!!!!!)
     * EXTENSIONS INCORPORATED INTO EXISTING CODE
     * (1) Bank Managers are associated with branches
     * (2) To be made tomorrow
     * @param args
     */
    public static void main(String[] args) {
        Manager m = new Manager("Nicolai", 1992);
        Customer c = new Customer("Pia", 1996);
        Branch b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);

        // Female customer creates (1) a current account and (2) a savings account at Bank 'b'.
        c.createCurrentAccount(b);
        c.createSavingsAccount(b);

        // Female customer deposits three different amounts to her current account at Bank 'b'.
        c.deposit(b, 33004782, 10);
        c.deposit(b, 33004782, 100);
        c.deposit(b, 33004782, 1000);

        // Female customer deposits three different amounts to her savings account at Bank 'b'.
        c.deposit(b, 69477450, 10);
        c.deposit(b, 69477450, 100);
        c.deposit(b, 69477450, 1000);

        // Female customer needs to withdraw 2000 of the money she deposited to Bank 'b', to buy the new iPhone 15 for Dave.
        c.withdraw(b, 33004782, 2000);

        // After being rejected, she tries to withdraw 1000 from each of her accounts at Bank 'b'.
        c.withdraw(b, 33004782, 1000);
        c.withdraw(b, 69477450, 1000);

        // With the female customer started to get annoyed, she tries to withdraw from a random account!
        c.withdraw(b, 123, 2000);

        // A last effort to acquire the money required for Dave's new iPhone would be to withdraw from a managers account!
        m.createCurrentAccount(b);
        m.deposit(b, 27624789, 10000000);
        c.withdraw(b, 27624789, 2000);

        // After failing to withdraw enough money from the Bank, she wants an overview of her transactions.
        c.generateBankStatement(b);

    }
}
