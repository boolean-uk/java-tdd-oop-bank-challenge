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
    String accountNumber;
    ArrayList<String> accounts;
    Bank bank;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public double countBalance(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList) {
        double balance = 0.00;

        do{
            List<LocalDate> creditDates = creditList.keySet().stream().toList();
            List<LocalDate> debitDates = debitList.keySet().stream().toList();

            LocalDate minimumDateCredit = creditDates.stream().min(LocalDate::compareTo).orElse(null);
            LocalDate minimumDateDebit = debitDates.stream().min(LocalDate::compareTo).orElse(null);
//            System.out.println("min credit " + minimumDateCredit);
//            System.out.println("min debit " + minimumDateDebit);
//
//            System.out.println("values credit " + creditList.values());
//            System.out.println("values debit " + debitList.values());

            if(minimumDateDebit != null && minimumDateCredit != null){
                if(minimumDateCredit.isBefore(minimumDateDebit)){
//                    System.out.println(creditList.get(minimumDateCredit));
                    for (double d : creditList.get(minimumDateCredit)){
                        balance += d;
                    }
                    creditList.remove(minimumDateCredit);
                } else if (minimumDateDebit.isBefore(minimumDateCredit)) {
                    for (double d : debitList.get(minimumDateDebit)){
                        balance -= d;
                    }
                    debitList.remove(minimumDateDebit);
                } else {
                    for (double d : creditList.get(minimumDateCredit)){
                        balance += d;
                    }
                    creditList.remove(minimumDateCredit);

                    for (double d : debitList.get(minimumDateCredit)){
                        balance -= d;
                    }
                    debitList.remove(minimumDateDebit);
                }
            } else if (minimumDateDebit == null && minimumDateCredit != null) {
                for (double d : creditList.get(minimumDateCredit)){
                    balance += d;
                }
                creditList.remove(minimumDateCredit);
            } else if (minimumDateCredit == null && minimumDateDebit != null) {
                for (double d : debitList.get(minimumDateDebit)){
                    balance -= d;
                }
                debitList.remove(minimumDateDebit);
            }

//            System.out.println(balance);
        } while (!creditList.isEmpty() || !debitList.isEmpty());

        return balance;
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

    public String generateBankStatements(HashMap<LocalDate, ArrayList<Double>> creditList, HashMap<LocalDate, ArrayList<Double>> debitList) {
        double balance = 0.00;
        StringBuilder sb = new StringBuilder();
        sb.append("date       || ");
        sb.append("credit  || ");
        sb.append("debit  || ");
        sb.append("balance \n");

        do {
            List<LocalDate> creditDates = creditList.keySet().stream().toList();
            List<LocalDate> debitDates = debitList.keySet().stream().toList();

            LocalDate minimumDateCredit = creditDates.stream().max(LocalDate::compareTo).orElse(null);
            LocalDate minimumDateDebit = debitDates.stream().max(LocalDate::compareTo).orElse(null);

            if (minimumDateDebit != null && minimumDateCredit != null) {
                if (minimumDateDebit.isAfter(minimumDateCredit)) {
                    sb.append(minimumDateDebit.format(dateFormat));
                    sb.append(" || ");
                    for (double d : debitList.get(minimumDateDebit)) {
                        sb.append("        || ");
                        sb.append(d + "  || ");
                        balance -= d;
                        sb.append(balance + "\n");
                    }
                    debitList.remove(minimumDateDebit);
                } else if (minimumDateCredit.isAfter(minimumDateDebit)) {
                    sb.append(minimumDateCredit.format(dateFormat));
                    sb.append(" || ");
                    for (double d : creditList.get(minimumDateCredit)) {
                        sb.append(d);
                        sb.append("  ||        || ");
                        balance += d;
                        sb.append(balance + "\n");
                    }
                    creditList.remove(minimumDateCredit);
                }else {
                    sb.append(minimumDateCredit.format(dateFormat));
                    sb.append(" || ");
                    for (double d : creditList.get(minimumDateCredit)){
                        sb.append(d);
                        sb.append("  ||        || ");
                        balance += d;
                        sb.append(balance + "\n");
                    }

                    sb.append(minimumDateDebit.format(dateFormat));
                    sb.append(" || ");
                    for (double d : debitList.get(minimumDateDebit)){
                        sb.append("        || ");
                        sb.append(d + "  || ");
                        balance -= d;
                        sb.append(balance + "\n");
                    }
                    creditList.remove(minimumDateCredit);
                    debitList.remove(minimumDateDebit);
                }
            } else if (minimumDateDebit == null && minimumDateCredit != null) {
                sb.append(minimumDateCredit.format(dateFormat));
                sb.append(" || ");
                for (double d : creditList.get(minimumDateCredit)){
                    sb.append(d);
                    sb.append("  ||        || ");
                    balance += d;
                    sb.append(balance + "\n");
                }
                creditList.remove(minimumDateCredit);
            } else if (minimumDateCredit == null && minimumDateDebit != null) {
                sb.append(minimumDateDebit.format(dateFormat));
                sb.append(" || ");
                for (double d : debitList.get(minimumDateDebit)){
                    sb.append("        || ");
                    sb.append(d + "  || ");
                    balance -= d;
                    sb.append(balance + "\n");
                }
                debitList.remove(minimumDateDebit);
            }
//            System.out.println(balance);
        } while (!creditList.isEmpty() || !debitList.isEmpty()) ;

        return sb.toString();
    }
}
