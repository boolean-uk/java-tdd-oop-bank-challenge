package com.booleanuk.core;

import java.util.ArrayList;

public interface Branch {
    enum Type {SAVINGS, CURRENT};
    void handleOverdraftRequest(double amountInCurrency, Account account);
    void createAndAddAccount(int accountNumber, Type type);


}
