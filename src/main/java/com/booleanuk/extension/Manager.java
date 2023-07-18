package com.booleanuk.extension;

public class Manager {
    private String fullName;

    public Manager(String fullName) {
        this.setFullName(fullName);
    }

    public boolean ApproveOverdraftRequest(NormalAccount normalAccount, double amount) {
        return normalAccount.getBalance() - amount > normalAccount.getDebit();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
