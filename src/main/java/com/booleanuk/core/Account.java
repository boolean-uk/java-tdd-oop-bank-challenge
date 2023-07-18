package com.booleanuk.core;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Account {
    LocalDate date;
    HashMap<LocalDate, ArrayList<Double>> debit = new HashMap<>();
    HashMap<LocalDate, ArrayList<Double>> credit = new HashMap<>();
    Bank bank;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    double balance;
    List<String> accounts;
    String accountNumber;

    public HashMap<LocalDate, ArrayList<Double>> getDebitList() {
        return debit;
    }

    public HashMap<LocalDate, ArrayList<Double>> getCreditList() {
        return credit;
    }

    public Account(Bank bank){
        this.bank = bank;
    }

    public String generateAccountNumber(Client client) {
        if(client != null){
            StringBuilder sb = new StringBuilder();
            sb.append(client.name.toUpperCase().trim());
            sb.append(client.lastName.toUpperCase());
            sb.append(client.birthDate.replaceAll(".", ""));
            sb.append(client.id.toUpperCase());
            String accountNumber = sb.toString();
            return accountNumber;
        } else return "";
    }

    public String createAccount(Client client) {
        if(bank.checkIfClientRegistered(client.id)){
            return generateAccountNumber(client);
        }else return "To create account you need to be registered";
    }

    public String deposit(double amount, LocalDate date) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0){
            if(!getCreditList().containsKey(date)){
                tmp.add(amount);
                getCreditList().put(date, tmp);
            } else {
                getCreditList().get(date).add(amount);
            }
            return "Money added to deposit";
        } else return "No money to add to deposit";
    }

    public String deposit(double amount) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0) {
            this.date = LocalDate.now();
            if(!getCreditList().containsKey(date)){
                tmp.add(amount);
                getCreditList().put(this.date, tmp);
            } else {
                getCreditList().get(date).add(amount);
            }
            return "Money added to deposit";
        } else return "No money to add to deposit";
    }

    public String withdraw(double amount, LocalDate date) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0){
            if(!getDebitList().containsKey(date)){
                tmp.add(amount);
                getDebitList().put(date, tmp);
            } else {
                getDebitList().get(date).add(amount);
            }
            return "Money withdrew";
        } else return "No money to withdraw from deposit";
    }

    public String withdraw(double amount) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0) {
            this.date = LocalDate.now();
            if(!getDebitList().containsKey(date)){
                tmp.add(amount);
                getDebitList().put(this.date, tmp);
            } else {
                getDebitList().get(date).add(amount);
            }
            return "Money withdrew";
        } else return "No money to withdraw from deposit";
    }

    public double countBalanceTotal(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList){
        double balance = 0.00;
        for (List<Double> creditAmounts : creditList.values()) {
            for (double credit : creditAmounts) {
                balance += credit;
            }
        }

        for (List<Double> debitAmounts : debitList.values()) {
            for (double debit : debitAmounts) {
                balance -= debit;
            }
        }
        return balance;
    }

    //extension balance calculated based on transaction history
    public String generateBankStatements(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList) {
        HashMap<LocalDate, ArrayList<Double>> tmpCreditList = creditList;
        HashMap<LocalDate, ArrayList<Double>> tmpDebitList = debitList;
        this.balance = countBalanceTotal(creditList, debitList);

        StringBuilder sb = new StringBuilder();
        sb.append("date       || ");
        sb.append("credit  || ");
        sb.append("debit  || ");
        sb.append("balance \n");

        List<LocalDate> allDates = new ArrayList<>();
        allDates.addAll(tmpCreditList.keySet());
        allDates.addAll(tmpDebitList.keySet());
        Collections.sort(allDates, Collections.reverseOrder());

        for (LocalDate date : allDates) {
            double previousValue = balance;
            sb.append(date.format(dateFormat));
            sb.append(" || ");
            if (tmpCreditList.containsKey(date)) {
                for (double d : tmpCreditList.get(date)) {
                    sb.append(d + "  ||        || ");
                    balance -= d;
                }
                tmpCreditList.remove(date);
            }
            if (tmpDebitList.containsKey(date)) {
                for (double d : tmpDebitList.get(date)) {
                    sb.append("        || ");
                    sb.append(d + "  || ");
                    balance += d;
                }
                tmpDebitList.remove(date);
            }
            sb.append(previousValue + "\n");
        }

        return sb.toString();
    }

    public boolean approveOverdraft(boolean isApproved) {
        return isApproved;
    }

    public String requestOverdraft(boolean isApproved){
        if (approveOverdraft(isApproved)) return "Overdraft approved";
        else return "Overdraft rejected";
    }

    public String withdrawOverdraft(double amount, LocalDate date, boolean isApproved) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0){
            if(countBalanceTotal(this.credit, this.debit) >= amount || approveOverdraft(isApproved)) {
                if (!getDebitList().containsKey(date)) {
                    tmp.add(amount);
                    getDebitList().put(date, tmp);
                } else {
                    getDebitList().get(date).add(amount);
                }
            }
            return requestOverdraft(isApproved);
        } else return "No money to withdraw from deposit";
    }

    public String withdrawOverdraft(double amount, boolean isApproved) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0) {
            if(countBalanceTotal(this.credit, this.debit) >= amount || approveOverdraft(isApproved)) {
                this.date = LocalDate.now();
                if (!getDebitList().containsKey(date)) {
                    tmp.add(amount);
                    getDebitList().put(this.date, tmp);
                } else {
                    getDebitList().get(date).add(amount);
                }
            }
            return requestOverdraft(isApproved);
        } else return "No money to withdraw from deposit";
    }
}
