package com.booleanuk.core;

import java.util.HashMap;
import java.util.Random;

public class AccountsList {
    private HashMap<String,Account> accounts;
    public AccountsList(){
        accounts = new HashMap<>();
    }

    /**
     * Generates a new random 8-digit account ID. The first four digits are the branch ID.
     * @param branchId
     * @return String: the new random-generated account ID.
     */
    public String generateAccountId(String branchId) {
        String accountId = "";
        do {
            Random random = new Random();
            String randomId = String.format("%04d", random.nextInt(10000));;
            accountId = branchId + randomId;
        } while (accounts.containsKey(accountId));
        return accountId;
    }

    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getAccountId())){
            return false;
        }else {
            accounts.put(account.getAccountId(),account);
            return true;
        }
    }


}
