package com.booleanuk.extension;

import java.util.HashMap;

public class Bank {
    private static final HashMap<String, Branch> branches = new HashMap<>() {{
        put("WCA", new Branch("Warsaw", "WCA", 400000));
        put("KRU", new Branch("Cracow", "KRU", 200000));
    }};

    public static Branch getBranch(String branchCode) {
        return branches.getOrDefault(branchCode, null);
    }
}
