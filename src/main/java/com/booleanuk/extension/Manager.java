package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Manager extends Person {
    private String position;
    public static List<Account> requests = new ArrayList<>();

    public Manager(String name, String surname, LocalDate birthdate, String position) {
        super(name, surname, birthdate);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String approve(Account account){
        if(requests.contains(account)){
            requests.add(account);

            return "Already in the list";
        }
        return "Approved";
    }

    public String reject(Account account){
        if(requests.contains(account)){
            requests.remove(account);
            return "Rejected";
        }
        return "Rejected";
    }

    @Override
    public String toString() {
        return "Manager{" +
                "position='" + position + '\'' +
                '}';
    }
}
