package com.booleanuk.core;

import java.time.LocalDateTime;
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
                case 2:
                    currentUser = view.chooseUser(new ArrayList<>(users));
                case 12:
                    users.add(new User("11", "Huey"));
                    users.add(new User("12", "Dewey"));
                    users.add(new User("21", "Louie"));
                    ArrayList<Account> accs = new ArrayList<>() {{
                    add(new CurrentAccount(users.getFirst().getUserId(), "0000", "000"));
                    add(new CurrentAccount(users.get(1).getUserId(), "0000", "001"));
                    add(new SavingsAccount(users.get(1).getUserId(), "0000", "002"));
                    add(new CurrentAccount(users.getLast().getUserId(), "0001", "003"));
                    add(new CurrentAccount(users.getLast().getUserId(), "0001", "004"));
                    add(new CurrentAccount(users.getLast().getUserId(), "0000", "005"));
                    }};
                    for (Account a: accs) {
                        depositables.put(a.getAccountId(), a);
                    }
                    Transaction t1 = new Transaction(LocalDateTime.now().minusDays(10), "-1", "000", 10000);
                    Transaction t2 = new Transaction(LocalDateTime.now().minusDays(6), "000", "001", 5000);
                    Transaction t3 = new Transaction(LocalDateTime.now().plusDays(1), "000", "002", 3000);
                    accs.getFirst().deposit(t1);
                    accs.getFirst().deposit(t2);
                    accs.get(1).deposit(t2);
                    accs.getFirst().deposit(t3);
                    accs.get(2).deposit(t3);
                    users.getFirst().addAccount(accs.get(0));
                    users.get(1).addAccount(accs.get(1));
                    users.get(1).addAccount(accs.get(2));
                    users.getLast().addAccount(accs.get(3));
                    users.getLast().addAccount(accs.get(4));
                    users.getLast().addAccount(accs.get(5));
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
