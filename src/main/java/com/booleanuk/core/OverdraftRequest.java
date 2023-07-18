package com.booleanuk.core;

public class OverdraftRequest {

    private int accountId;
    private int ammountRequested;
    private Boolean answer;

    public OverdraftRequest (int accountId, int ammountRequested) {
        this.accountId = accountId;
        this.ammountRequested = ammountRequested;
        this.answer = null;
    }

    //getters and setters
    public int getAccountId() {
        return accountId;
    }

    public int getAmmountRequested() {
        return ammountRequested;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }


}
