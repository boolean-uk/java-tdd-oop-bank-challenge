package com.booleanuk.core.Users;

import com.booleanuk.core.Bank.Branch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manager extends User{
    private Branch branch;
    public Manager(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
}
