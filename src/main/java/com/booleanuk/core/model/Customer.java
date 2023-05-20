package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.ACCOUNT_TYPE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private final String tin;
    private final String idCardCode;
    private String givenNames;
    private String surname;
    private final LocalDate dateOfBirth;
    private Branch branch;
    private List<Account> accounts;

    Customer(String tin, String idCardCode, String givenNames, String surname, LocalDate dateOfBirth, Branch branch) {
        if (tin == null || idCardCode == null || givenNames == null || surname == null
                || dateOfBirth == null || branch == null)
            throw new NullPointerException("All fields must be non-null.");
        if (!isTINValid(tin))
            throw new IllegalArgumentException("Tax Identification Number is not valid.");

        this.tin = tin.trim().toUpperCase();
        this.idCardCode = idCardCode.trim();
        this.givenNames = givenNames.trim();
        this.surname = surname.trim();
        this.dateOfBirth = dateOfBirth;
        this.branch = branch;
        this.accounts = new ArrayList<>();
    }

    private static boolean isTINValid(String tin) {
        return tin.trim().toUpperCase().matches("^[A-Za-z]{2}\\d{9}$");
    }

    public void createAccount(ACCOUNT_TYPE accountType, BigDecimal amount) {
        if (accountType == null || amount == null)
            throw new NullPointerException("Account type and amount must be non-null.");

        Account account = null;
        switch (accountType) {
            case CURRENT: account = new CurrentAccount(amount, this); break;
            case SAVINGS: account = new SavingsAccount(amount, this); break;
        }

        this.accounts.add(account);
    }

    public void createAccount(ACCOUNT_TYPE accountType) {
        this.createAccount(accountType, BigDecimal.ZERO);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Branch getBranch() {
        return branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return Objects.equals(tin, customer.tin) || Objects.equals(idCardCode, customer.idCardCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tin, idCardCode);
    }
}
