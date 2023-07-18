package com.booleanuk.extensions;

public enum BankBranch {
    WARSAW(11234L),
    KRAKOW(432L),
    GDANSK(5843L),
    HELL(4321L);
    private final Long idNumber;

    BankBranch(Long idNumber) {
        this.idNumber = idNumber;
    }
}
