package com.booleanuk.core;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<LocalDate> transactionDates = new ArrayList<>();
    private List<Double> credits = new ArrayList<>();
    private List<Double> debits = new ArrayList<>();
    private List<Double> balanceList = new ArrayList<>();

    private BankStatement bs = new BankStatement();

    public Account(){
        this.transactionDates = transactionDates;
        this.debits = debits;
        this.credits = credits;
        this.balanceList = balanceList;
        this.bs = bs;

    }

    public List<LocalDate> getTransactionDates(){
        return this.transactionDates;
    }

    public List<Double> getCredits(){
        return this.credits;
    }

    public List<Double> getDebits(){
        return this.debits;
    }

    public List<Double> getBalanceList(){
        return this.balanceList;
    }

    public void depositAccount(double amount){
        transactionDates.add(bs.getDate());
        credits.add(amount);
        debits.add(0.0);
        balanceList.add(bs.deposit(amount));
    }

    public String withdrawAccount(double amount){
        if(amount > bs.getBalance()){
            return "You don´t have enough money in your account, sorry";
        }
        transactionDates.add(bs.getDate());
        credits.add(0.0);
        debits.add(amount);
        balanceList.add(bs.withdraw(amount));

        return "Thank you for using our services";
    }

    public String PrintAccount() {
        StringBuilder sb = new StringBuilder();
        sb.append("date       || credit  || debit  || balance" + "\n");
        for (int i = transactionDates.size() - 1; i >= 0; i--) {
            sb.append(transactionDates.get(i) + " " + "||");
            if (credits.get(i) == 0.0) {
                sb.append("         ||");
            } else {
                sb.append(credits.get(i)+"   $||");
            }
            if (debits.get(i) == 0.0) {
                sb.append("        ||");
            } else {
                sb.append(debits.get(i)+"  $||");
            }
            sb.append(balanceList.get(i)+"  $" + "\n");


        }
        return sb.toString();

    }



}
