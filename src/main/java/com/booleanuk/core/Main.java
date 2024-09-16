package com.booleanuk.core;

public class Main {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToSavings(new UsDollar(500));
        bankAccount.depositMoneyToCurrent(new UsDollar(100));
        bankAccount.depositMoneyToSavings(new UsDollar(2000));
        bankAccount.withdrawMoney(new UsDollar(300));
        bankAccount.depositMoneyToCurrent(new UsDollar(400));
        bankAccount.depositMoneyToCurrent(new UsDollar(500));
        bankAccount.depositMoneyToCurrent(new UsDollar(700));

        bankAccount.withdrawMoneyFromSavings(new UsDollar(600));

        bankAccount.listBalanceStatement();


        }
}