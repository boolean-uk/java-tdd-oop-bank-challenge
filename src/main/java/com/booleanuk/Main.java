package com.booleanuk;

import com.booleanuk.extension.Branch;
import com.booleanuk.extension.CurrentAccount;
import com.booleanuk.extension.Util;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        CurrentAccount account = new CurrentAccount(0,new Branch("XXXX","XXX"));
        account.deposit(1000.00, LocalDate.of(2012, 1, 10));
        account.deposit(2000.00, LocalDate.of(2012, 1, 13));
        account.withdraw(500.00, LocalDate.of(2012, 1, 14));

        Util.sendSms("\n"+account.generateStatement());
    }
}
