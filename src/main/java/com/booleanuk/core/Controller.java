package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    public static HashMap<String, Depositable> depositables = new HashMap<>();
    private ArrayList<User> users;
    private User currentUser;
    private View view;

    public Controller() {
        users = new ArrayList<>();
        currentUser = null;
        view = new View();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }

    private void start() {
        System.out.println("TODO");
    }
}
