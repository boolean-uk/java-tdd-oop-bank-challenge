package com.booleanuk.core;

import com.booleanuk.core.model.*;
import com.booleanuk.core.model.enumerations.ACCOUNT_TYPE;
import com.booleanuk.core.model.enumerations.OVERDRAFT_STATE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Run Main to print bank statement
        Bank alphabank = generateSampleDate();
    }

    public static Bank generateSampleDate() {
        Bank alphaBank = null;
        try {
            Locale locale = new Locale("el", "GR");
            BankManager bankManager = new BankManager();
            alphaBank = new Bank("Alpha Bank", "140", locale, bankManager);

            alphaBank.createBranch("Central", "1010");
            Branch centralBranch = alphaBank.getBranches().get(0);

            LocalDate dateOfBirth = LocalDate.parse("1992-04-04");
            centralBranch.createCustomer("GR123456788", "AT1312", "Dimitris", "Tsimaras",
                    dateOfBirth);

            Customer customer = centralBranch.getCustomers().get(0);

            customer.createAccount(ACCOUNT_TYPE.CURRENT, new BigDecimal(400));

            Account account = customer.getAccounts().get(0);

            account.deposit(new BigDecimal(600));
            account.withdraw(new BigDecimal(300));
            account.deposit(new BigDecimal(700));
            account.withdraw(new BigDecimal(200));
            account.deposit(new BigDecimal(800));

            CurrentAccount currentAccount = null;
            if (account instanceof CurrentAccount) {
                currentAccount = (CurrentAccount) account;
            }
            currentAccount.requestOverdraft(new BigDecimal("3000"));
            var request = currentAccount.getOverdraftRequests().get(0);
            bankManager.processOverdraftRequest(request, OVERDRAFT_STATE.APPROVED);
            currentAccount.overdraft(request);

            account.deposit(new BigDecimal(300));
            account.printBankStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alphaBank;
    }
}
