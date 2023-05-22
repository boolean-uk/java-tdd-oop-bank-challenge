package com.booleanuk.core;

import com.booleanuk.core.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Run Main to create sample data and print bank statement
        System.out.println("Hello User!");
        generateSampleData();
    }

    public static void generateSampleData() {
        Locale locale = new Locale("el", "GR");

        BankController controller = new BankController("Alpha Bank", "140", locale);
        controller.createBankManager();

        Branch branch = controller.createBranch("Central", "1010");
        Customer customer = controller.createCustomer(branch, "GR123456789", "AT1312", "Dimitris",
                "Tsimaras", LocalDate.parse("1992-04-04"));
        CurrentAccount currentAccount = controller.createCurrentAccount(customer);

        controller.deposit(currentAccount,new BigDecimal(100));
        controller.deposit(currentAccount,new BigDecimal(200));
        controller.withdraw(currentAccount, new BigDecimal(150));
        controller.deposit(currentAccount,new BigDecimal(250));

        controller.withdraw(currentAccount, new BigDecimal(1000));

        OverdraftRequest request = controller.createOverdraftRequest(currentAccount, new BigDecimal(500));
        controller.approveOverdraftRequest(request);
        controller.overdraft(currentAccount, request);

        controller.deposit(currentAccount,new BigDecimal(100));

        controller.printBankStatement(currentAccount);
        controller.sendBankStatementToPhone(currentAccount);
    }
}
