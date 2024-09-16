package com.booleanuk.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class BankAccount {
    LinkedHashMap<String, List<Transaction>> accounts;
    private float overDraftAmount;
    private float overDraftRequestedAmount;

    public BankAccount() {
        accounts = new LinkedHashMap<>();
        accounts.put("main", new ArrayList<>());
        accounts.put("savings", new ArrayList<>());
        overDraftAmount = 0;
    }

    public boolean deposit(String accountName, float amount, LocalDate date) {
        if(!accounts.containsKey(accountName) || amount <= 0)
            return false;

        Transaction transaction = new Transaction(date, amount);
        accounts.get(accountName).add(transaction);
        return true;
    }

    public boolean withdraw(String accountName, float amount, LocalDate date) {
        if(!accounts.containsKey(accountName) || amount <= 0)
            return false;

        AtomicReference<Float> balance = new AtomicReference<>(0f);
        List<Transaction> transactions = accounts.get(accountName);
        transactions.stream().forEach(
                transaction -> balance.updateAndGet(currentBalance -> currentBalance + transaction.amount));

        if(balance.get() + overDraftAmount < amount)
            return false;

        Transaction transaction = new Transaction(date, -amount);
        transactions.add(transaction);
        return true;
    }

    public String showAccountHistory(String accountName) {
        if(!accounts.containsKey(accountName))
            return "accountName is not matching with any account";

        List<Transaction> account = accounts.get(accountName);
        StringBuilder result = new StringBuilder();
        result.append("date       || credit  || debit  || balance\n");
        AtomicReference<Float> balance = new AtomicReference<>(0f);
        String transactionsString = account.stream().map(transaction -> {
                balance.updateAndGet(currentBalance -> currentBalance + transaction.amount);
                return rightPad(transaction.date.toString(), 10)
                        + " || "
                        + (transaction.amount > 0 ?
                        rightPad(Float.toString(transaction.amount), 8) + "||" + " ".repeat(8)
                        : " ".repeat(8) + "|| " + rightPad(Float.toString(-transaction.amount), 7))
                        + "|| " + balance;}
        ).collect(Collectors.joining("\n"));

        result.append(transactionsString);
        return result.toString();
    }
    private String rightPad(String text, int length) { return String.format("%-" + length + "." + length + "s", text); }

    public boolean requestOverDraft(float amount) {
        if(amount < 0)
            return false;

        overDraftRequestedAmount = amount;
        return true;
    }

    public float getOverDraftRequestedAmount() {
        return overDraftRequestedAmount;
    }

    public boolean approveOverDraftAmount(float amount) {
        if(amount < 0 || amount != overDraftRequestedAmount)
            return false;

        overDraftAmount = overDraftRequestedAmount;
        overDraftRequestedAmount = 0;
        return true;
    }

    public void sendSMS(String accountName) throws IOException {
        if(!accounts.containsKey(accountName))
            return ;

        String appConfigPath = "config.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        String ACCOUNT_SID = appProps.getProperty("ACCOUNT_SID");
        String AUTH_TOKEN = appProps.getProperty("AUTH_TOKEN");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String RECIPIENT_PHONE_NUMBER = appProps.getProperty("RECIPIENT_PHONE_NUMBER");
        String YOUR_TWILIO_PHONE_NUMBER = appProps.getProperty("YOUR_TWILIO_PHONE_NUMBER");

        String messageString = this.showAccountHistory(accountName);
        Message.creator(
                        new PhoneNumber(RECIPIENT_PHONE_NUMBER),  // Destination phone number
                        new PhoneNumber(YOUR_TWILIO_PHONE_NUMBER),  // Your Twilio phone number
                        messageString)  // Message content
                .create();;
    }
}
