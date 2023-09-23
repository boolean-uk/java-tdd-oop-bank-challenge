package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User extends BaseEntity {
    private String name;
    private List<Account> accounts;

    public User(String name) {
        this.name = name;
    }
}
