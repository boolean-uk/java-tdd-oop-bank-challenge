package com.booleanuk.core;

import java.util.ArrayList;

public class BranchList {
    ArrayList<Branch> availableBranches;

    //dependency injection
    public BranchList(ArrayList<Branch> availableBranches) {
        this.availableBranches = availableBranches;
    }

    public BranchList() {
        this.availableBranches = new ArrayList<>();
        this.availableBranches.add(new Branch("Main St. 12, Athens", 1,100));
        this.availableBranches.add(new Branch("Notsomain St. 40, Thessaloniki", 2,80));
        this.availableBranches.add(new Branch("Kolokotronis 25, Patras", 3,75));
        this.availableBranches.add(new Branch("King's Road 55, Piraeus", 4,95));
    }
}
