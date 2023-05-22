package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        Bank alphaBank = new Bank("Alpha Bank");
        Branch alphaAthensBranch = alphaBank.createBranch("Alpha Athens");

        String customerId = alphaAthensBranch.createCustomer();

        alphaAthensBranch.createAccount(customerId, Bank.AccountType.CURRENT, 2000);

    }
}
