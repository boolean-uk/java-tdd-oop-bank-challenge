package com.booleanuk.core;

public class BankManager {

    public static boolean evaluateOverdraftRequest(OverdraftRequest request, Bank.OverdraftStatus newStatus){
        if(request == null) return false;
        if(!request.getStatus().equals(Bank.OverdraftStatus.PENDING)) return false;

        request.setStatus(newStatus);
        return true;
    }
}
