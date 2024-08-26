package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchName;

    public Branch(String branchName) {
        this.branchName = branchName;
    }



    @Override
    public String toString() {
        return branchName;
    }


}
