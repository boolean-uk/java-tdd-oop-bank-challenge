package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankManager {
    private final List<Branch> branches;
    private List<Client> clients;

    public BankManager() {
        this.branches = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void removeBranch(Branch branch) {
        branches.remove(branch);
    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Branch> getBranches() {
        return branches;
    }
    public void addClient(Client client) {
        clients.add(client);
    }
    public Client getClientById(String clientId) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

}
