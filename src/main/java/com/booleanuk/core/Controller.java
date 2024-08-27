package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
        controller.mainMenu();
    }

    private void mainMenu() {
        boolean keepRunning = true;
        while (keepRunning) {
            int chosenOption = view.mainMenu();
            switch (chosenOption) {
                case 1:
                    String userId = generateUserId();
                    users.add(view.getUser(userId));
                    view.printUser(users.getLast());
                    break;
                case 12:
                    users.add(new User("11", "Huey"));
                    users.add(new User("12", "Dewey"));
                    users.add(new User("21", "Louie"));
                    Account a1 = new CurrentAccount(users.getFirst().getUserId(), "0000", "000");
                    Account a2 = new CurrentAccount(users.get(1).getUserId(), "0000", "001");
                    Account a3 = new SavingsAccount(users.get(1).getUserId(), "0000", "002");
                    Account a4 = new CurrentAccount(users.getLast().getUserId(), "0001", "003");
                    Account a5 = new CurrentAccount(users.getLast().getUserId(), "0001", "004");
                    Account a6 = new CurrentAccount(users.getLast().getUserId(), "0000", "005");
                    users.getFirst().addAccount(a1);
                    users.get(1).addAccount(a2);
                    users.get(1).addAccount(a3);
                    users.getLast().addAccount(a4);
                    users.getLast().addAccount(a5);
                    users.getLast().addAccount(a6);
                    System.out.println("Accounts added");
                    break;
                default:
                    keepRunning = false;
            }
        }
    }

    private String generateUserId() {
        Random random = new Random();
        long randomNumber = random.nextLong() % 10000000000L;
        randomNumber = Math.abs(randomNumber);
        String stringNumber = String.format("%010d", randomNumber);
        String finalStringNumber = stringNumber;
        if (users.stream().anyMatch(user -> user.getUserId().equals(finalStringNumber))) {
            stringNumber = generateUserId();
        }
        return stringNumber;
    }
}
