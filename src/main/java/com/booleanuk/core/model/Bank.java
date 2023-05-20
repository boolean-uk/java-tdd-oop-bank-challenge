package com.booleanuk.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Bank {
    private String bankName;
    private final String bankCode;
    private final Locale locale;
    private BankManager bankManager;
    private final List<Branch> branches;

    public Bank(String bankName, String bankCode, Locale locale, BankManager bankManager) {
        if (bankName == null || bankCode == null || locale == null)
            throw new NullPointerException("All fields except bankManager must be non-null.");
        if (!isThreeDigitNumber(bankCode))
            throw new IllegalArgumentException("Bank code must be a three digit positive number.");

        this.bankName = bankName.trim();
        this.bankCode = bankCode.trim();
        this.locale = locale;
        this.bankManager = bankManager;
        this.branches = new ArrayList<>();
    }

    public Bank(String bankName, String bankCode, Locale locale) {
        this(bankName, bankCode, locale, null);
    }

    private static boolean isThreeDigitNumber(String strNum) {
        if (strNum == null || strNum.trim().isEmpty()) return false;
        return strNum.trim().matches("\\d{3}");
    }
    public void createBranch(String branchName, String branchCode) {
        Branch branch = new Branch(branchName, branchCode, this);
        if (branches.contains(branch)) {
            System.out.println("Branch is already registered with the bank.");
        } else {
            branches.add(branch);
            System.out.println("Branch successfully added to the bank.");
        }
    }

    public List<Branch> getBranches() { return this.branches; }

    public String getBankCode() { return bankCode; }

    public Locale getLocale() { return locale; }
}
