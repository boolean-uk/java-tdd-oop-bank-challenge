package com.booleanuk.extension;

import java.util.HashMap;
import java.util.LinkedList;

/*
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
*/

public class User {
    /*
    public static final String ACCOUNT_SID = MY_ACCOUNT_SID;
    public static final String AUTH_TOKEN = MY_AUTH_TOKEN;
    */
    private final HashMap<String, BankAccount> ownedAccounts;
    private final LinkedList<Request> requests;
    private final String firstName;
    private final String lastName;
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownedAccounts = new HashMap<String, BankAccount>();
        this.requests = new LinkedList<Request>();
    }
    public boolean createNewAccount(String accountType, double initialBalance, String id, Branch branch) {
        //normally I would create console interface, but this is for tests
        if(ownedAccounts.containsKey(id))
            return false;
        switch (accountType) {
            case "savings" -> ownedAccounts.put(id, new SavingsAccount(initialBalance, branch));
            case "current" -> ownedAccounts.put(id, new CurrentAccount(initialBalance, branch));
            default -> { return false; }
        }
        return true;
    }
    public OverdraftRequest makeOverdraftRequest(double amount) {
        OverdraftRequest req = new OverdraftRequest(amount);
        requests.add(req);
        return req;
    }
    public String getRequestsInfo() {
        StringBuilder sb = new StringBuilder();
        for(Request req : requests)
            sb.append(req);
        return sb.toString();
    }
    public BankAccount getAccountById(String id) {
        return ownedAccounts.get(id);
    }
    public boolean getBankAccountStatement(String id) {
        if(!ownedAccounts.containsKey(id))
            return false;
        String statement = getAccountById(id).generateStatement();
        /*
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+48111111111"), //sender number
                        new com.twilio.type.PhoneNumber("+48222222222"), //receiver number
                        statement)
                .create();
         */
        return true;
    }
}


