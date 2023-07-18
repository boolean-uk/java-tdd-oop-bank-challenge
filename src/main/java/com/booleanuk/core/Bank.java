package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    ArrayList<Client> clientsOfBank;

    public Bank(){
        clientsOfBank = new ArrayList<>();
        clientsOfBank.add(new Client("John", "Smith", "01.01.1998", "234"));
        clientsOfBank.add(new Client("Jan", "Nowak", "08.03.1950", "345"));
        clientsOfBank.add(new Client("Ewa", "Apple", "25.11.1986", "456"));
        clientsOfBank.add(new Client("Bartek", "Johnson", "23.08.2000", "567"));
    }

    public List<Client> getClientList() {
        return clientsOfBank;
    }

    public void register(String name, String lastName, String birthDate, String id) throws Exception{
        if(birthDate.contains(".") && !checkIfClientRegistered(id)) clientsOfBank.add(new Client(name, lastName, birthDate, id)); //to correct with three dots
        else throw new Exception("Can not be registered");
    }

    public Client getClientByID(String id){
        return clientsOfBank.stream().filter(e -> (e.id.equals(id))).findFirst().orElse(null);
    }

    public boolean checkIfClientRegistered(String id){
        if(clientsOfBank.stream().anyMatch(e -> (e.id.equals(id)))){
            return true;
        }else return false;
    }


}
