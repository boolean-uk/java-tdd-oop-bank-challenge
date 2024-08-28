package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Request> requests;

    public Bank() {
        this.requests = new HashMap<>();
    }

    public Map<String, Request> getAllRequests() {
        return this.requests;
    }

    private void addRequest(Request request) {
        this.requests.put(request.getId(), request);
    }

    public void makeRequest(Request request) {
        this.addRequest(request);
    }

    private void removeRequest(String requestId) {
        this.requests.remove(requestId);
    }
}
