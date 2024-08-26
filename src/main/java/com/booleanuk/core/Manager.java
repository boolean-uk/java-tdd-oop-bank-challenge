package com.booleanuk.core;

public class Manager extends Person {
    public Manager(String name, int UID) {
        super(name, UID);
    }

    /**
     * Logic: Takes a Customer via DI to alternate its creditScore. This way, a customer cannot modify its own creditScore.
     * @param customer
     * @param creditScore
     * @return
     */
    public boolean setCreditScore(Customer customer, CreditScore creditScore) {
        try {
        customer.setCreditScore(creditScore);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
