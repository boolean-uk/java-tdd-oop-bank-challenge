package com.booleanuk.core;

public interface Bank {
    String getName();

    void setName(String name);

    String getLocation();

    void setLocation(String location);

    int getBranchID();

    void setBranchID(int branchID);

    Manager getManager();

    void setManager(Manager manager);
}
