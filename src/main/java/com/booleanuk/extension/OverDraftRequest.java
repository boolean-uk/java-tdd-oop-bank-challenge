package com.booleanuk.extension;

public class OverDraftRequest {
    private boolean isAccepted;
    private boolean isPending;
    private double limit;
    private CurrentAccount account;

    public OverDraftRequest(double limit, CurrentAccount account) {
        this.isAccepted = false;
        this.isPending = true;
        this.limit = limit;
        this.account = account;
    }

    public String acceptRequest(){
        this.isAccepted = true;
        this.account.setOverDraftLimit(this.limit);
        this.isPending = false;
        return "request accepted";
    }

    public String rejectRequest(){
        this.isPending = false;
        return "request rejected";
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public boolean isPending() {
        return isPending;
    }
}
