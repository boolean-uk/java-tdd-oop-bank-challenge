package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<>();

    public void createBranch(){
        Branch branch = new Branch();
        branches.add(branch);
    }

    public Branch getBranchByID(int id){
        for (Branch b : branches){
            if (b.getBranchID() == id){
                return b;
            }
        }
        System.out.println("Non-existing or not valid branch ID!");
        return null;
    }

    public ArrayList<Branch> getBranches(){
        return this.branches;
    }

}
