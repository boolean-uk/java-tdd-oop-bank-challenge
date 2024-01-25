package com.booleanuk.extension;

public class OverDraftRequest {
    boolean isAccepted;
    boolean isPending;
    double limit;
    CurrentAccount account;

    public OverDraftRequest(double limit, CurrentAccount account) {
        this.isAccepted = false;
        this.isPending = true;
        this.limit = limit;
        this.account = account;
    }

    public String acceptRequest(){
        return "";
    }

    public String declineRequest(){
        return "";
    }
}
