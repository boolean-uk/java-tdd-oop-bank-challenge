package com.booleanuk.core;

public class Manager{
    private double maximumOverdraft;
    private String name;
    private String branch;
    public Manager(String name, String branch) {
        this.name = name;
        this.branch = branch;
        this.maximumOverdraft = 0;
    }

    public double getMaximumOverdraft() {
        return maximumOverdraft;
    }

    public void setMaximumOverdraft(double maximumOverdraft) {
        this.maximumOverdraft = -maximumOverdraft;
    }
}
