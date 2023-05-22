//package com.booleanuk.core;
//
//public class BankAccount {
//    private String accountNumber;
//    private double balance;
//    private String accountOwner;
//
//        // constructor
//        public BankAccount(String accountNumber, double balance, String accountOwner) {
//            this.accountNumber = accountNumber;
//            this.balance = balance;
//            this.accountOwner = accountOwner;
//        }
//
//    // deposit method
//    public void deposit(double amount) {
//        balance += amount;
//    }
//
//    // withdraw method
//    public void withdraw(double amount) {
//        if (balance >= amount) {
//            balance -= amount;
//        } else {
//            System.out.println("There is not enough money on your account.");
//        }
//    }
//
//        // getters and setters
////        public String getAccountNumber() {
////            return accountNumber;
////        }
////
////        public void setAccountNumber(String accountNumber) {
////            this.accountNumber = accountNumber;
////        }
//
//        public double getBalance() {
//            return balance;
//        }
//
//        public void setBalance(double balance) {
//            this.balance = balance;
//        }
//
//        public String getAccountOwner() {
//            return accountOwner;
//        }
//
//        public void setAccountOwner(String ownerName) {
//            this.accountOwner = ownerName;
//        }
//
//
//    // toString method
////    @Override
////    public String toString() {
////        return "BankAccount{" +
////                "accountNumber='" + accountNumber + '\'' +
////                ", balance=" + balance +
////                ", ownerName='" + ownerName + '\'' +
////                '}';
////    }
//}
