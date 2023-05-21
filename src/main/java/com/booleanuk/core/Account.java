package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    private int id;
    private String type;
    private int balance;
    private int customerId;
    private ArrayList<Statement> statements;

    public Account(int id, int customerId, String type, int initalDeposit){
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = initalDeposit;
        this.statements = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public static int getUniqueRandomAccountId () {
        Random rand = new Random();
        int upperbound = 99;
        int x1 = rand.nextInt(upperbound);
        int x2 = rand.nextInt(upperbound);
        int x3 = rand.nextInt(upperbound);
        int x4 = rand.nextInt(upperbound);
        String idString = Integer.toString(x1) + Integer.toString(x2) + Integer.toString(x3) + Integer.toString(x4);
        int id = Integer.parseInt(idString);
        return id;
    }

    public void addDepositStatement (int ammount) {  //used for account creation too
        getStatements().add(new Statement( getCustomerId(), getId(), ammount, 0, Statement.getDateNow()));
    }

    public void addWithdrawStatement (int ammount) {
        getStatements().add(new Statement( getCustomerId(), getId(), 0, ammount, Statement.getDateNow()));
    }

    public void generateStatements () {
        ArrayList<String> statementsMessages = new ArrayList<>();
        int balanceX = 0;
        System.out.println("date       || credit\t\t|| debit\t\t|| balance");
        for (Statement statement: getStatements()) {
            int credit = statement.getCredit();
            int debit = statement.getDebit();
            if ( debit == 0) {  //if debit is 0, then this statement is a deposit/credit one
                balanceX += credit;
                statementsMessages.add(statement.getDate()+ " || " + credit + "\t\t\t|| \t\t\t\t|| "+ balanceX);
            } else {
                balanceX -= debit;
                statementsMessages.add(statement.getDate()+ " || \t\t\t\t|| " + debit + "\t\t\t|| " + balanceX);
            }
        }
        for (int i = statementsMessages.size()-1; i >= 0 ; i--) {
            System.out.println(statementsMessages.get(i));
        }
    }

}
