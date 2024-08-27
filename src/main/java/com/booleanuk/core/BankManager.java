package com.booleanuk.core;

import java.util.ArrayList;

public class BankManager {
    private ArrayList<OverdraftRequest> pendingRequests;
    private static final double MIN = 0.0;
    private static final double MAX = 1000.0;

    public BankManager() {
        this.pendingRequests = new ArrayList<>();
    }

    public void receiveRequest(OverdraftRequest request) {
        this.pendingRequests.add(request);
    }

    public void processRequest() {
        for (OverdraftRequest request : this.pendingRequests) {
            double limit = request.getRequestedLimit();
            boolean requestCondition = limit > MIN && limit <= MAX;
            if (requestCondition) {
                request.approve();
                System.out.println("Request approved for account: " + request.getAccount().getAccountNumber() + "\n");
            }
            else {
                request.reject();
                System.out.println("Request rejected for account: " + request.getAccount().getAccountNumber());
                System.out.println("Maximum overdraft amount is: " + MAX);
            }
        }
        // Remove the requests after they have been processed.
        pendingRequests.clear();
    }
}
