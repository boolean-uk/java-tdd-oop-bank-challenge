package com.booleanuk.core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Branch {
    private String branchName;
    private final String branchCode;
    private final Bank bank;
    private final List<Customer> customers;

    Branch(String branchName, String branchCode, Bank bank) {
        if (branchName == null || branchCode == null || bank == null)
            throw new NullPointerException("All fields must be non-null.");
        if (!isFourDigitNumber(branchCode))
            throw new IllegalArgumentException("Branch code must be a four digit positive number.");

        this.branchName = branchName.trim();
        this.branchCode = branchCode.trim();
        this.bank = bank;
        this.customers = new ArrayList<>();
    }

    private static boolean isFourDigitNumber(String strNum) {
        if (strNum == null || strNum.trim().isEmpty()) return false;
        return strNum.trim().matches("\\d{4}");
    }

    public void createCustomer(String tin, String idCard, String givenNames, String surname, LocalDate dateOfBirth) {
        Customer customer = new Customer(tin, idCard, givenNames, surname, dateOfBirth, this);
        if (customers.contains(customer)) {
            System.out.println("Customer is already registered.");
        } else {
            customers.add(customer);
            System.out.println("Customer successfully registered.");
        }
    }

    boolean isAccountNumberUnique(String accountNumber) {
        return this.customers.stream().flatMap(customer -> customer.getAccounts().stream())
                .noneMatch(account -> accountNumber.equals(account.getAccountNumber()));
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public Bank getBank() { return this.bank; }

    public String getBranchCode() { return this.branchCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Branch branch = (Branch) o;
        return Objects.equals(branchName, branch.branchName) || Objects.equals(branchCode, branch.branchCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchName, branchCode);
    }
}
