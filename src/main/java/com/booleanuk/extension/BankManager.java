package com.booleanuk.extension;

public class BankManager {

    public BankManager() {
    }

    public String decideRequest(OverDraftRequest request, boolean accept){
        if(accept){
            return request.acceptRequest();
        }
        return request.rejectRequest();
    }
}
