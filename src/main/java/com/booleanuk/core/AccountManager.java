package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;


public class AccountManager {


    private static ArrayList<Account> accounts;


    private static ArrayList<Overdraft> overdrafts;

    public AccountManager() {
        accounts = new ArrayList<>();
        overdrafts = new ArrayList<Overdraft>();
    }

    public Account createAccount(Client client) {
        Account account = new Account(client);
        accounts.add(account);
        return account;
    }

    public SavingAccount createSavingAccount(Client client) {
        SavingAccount savingAccount = new SavingAccount(client);
        accounts.add(savingAccount);
        return savingAccount;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addDeposit(Account account, BigDecimal deposit) {
        if(deposit.doubleValue() > 0) {
            BigDecimal currentBalance = account.getBalance();
            currentBalance = currentBalance.add(deposit);
            account.getStatements().add(new Transaction(deposit,currentBalance));
        }else{
            System.out.println("You can not deposit money below zero!");
        }
    }


    public BigDecimal calculateAccountBalance(Account account) {
      return   account.getBalance();
    }

    public void withdraw(Account account, BigDecimal withdraw) {


        if(withdraw.doubleValue() < 0){
            System.out.println("You can't withdraw money below zero!");
        }else{
            withdraw = withdraw.multiply(BigDecimal.valueOf(-1));
            BigDecimal currentBalance = account.getBalance();
            currentBalance = currentBalance.add(withdraw);

            account.getStatements().add(new Transaction(withdraw,currentBalance));
        }
    }

    public String generateBankStatement(Account account) {
        StringBuilder bankStatement = new StringBuilder("\ndate       || credit  || debit  || balance\n");
        account.getStatements().forEach(transaction -> {
            bankStatement.append(transaction.getCreatedAt().getYear())
                    .append("/")
                    .append(transaction.getCreatedAt().getMonth())
                    .append("/")
                    .append(transaction.getCreatedAt().getDayOfMonth())
                    .append(" || ")
                    .append(transaction.getCredit())
                    .append(" || ")
                    .append(transaction.getDebit())
                    .append(" || ")
                    .append(transaction.getCurrentBalance())
                    .append("\n");
        });

        return bankStatement.toString();
    }


    public void linkAccountToBranch(Account account, Branch branch) {
        account.setBranch(branch);
    }

    public static ArrayList<Overdraft> getOverDrafts() {
        return overdrafts;
    }

    public static void setOverDrafts(ArrayList<Overdraft> overdrafts) {
        AccountManager.overdrafts = overdrafts;
    }

    public Overdraft addRequestToOverdraft(Account account, BigDecimal overdraft) {
        Overdraft overdraft1 = new Overdraft(account, overdraft);
        overdrafts.add(overdraft1);
        return overdraft1;
    }

    public void approveOverdraft(Overdraft overDraft){
        overDraft.getAccount().setOverdraft(overDraft.getOverdraft());
        overdrafts.remove(overDraft);
    }


}
