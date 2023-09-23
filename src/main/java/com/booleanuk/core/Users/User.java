package com.booleanuk.core.Users;

import com.booleanuk.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseEntity {
    private String name;

    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }
}
