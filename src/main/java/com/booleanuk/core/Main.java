package com.booleanuk.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader;
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Log in as(insert number to log in)\n[1] - Client\n[2] - Bank Manager");
        try {
            int option = Integer.parseInt(reader.readLine());
            System.out.println(option);
            switch (option){
                case 1 : clientMenu(); break;
                case 2 : managerMenu(); break;
                default:
                    System.out.println("You inserted wrong number!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void managerMenu() throws IOException {
        System.out.println("What would you like to do:\n [1] - Create Current Account\n[2] - Create saving account\n[3] - Genereate bank statementes\n [4] - Deposit Money\n[5] - Withdraw Money \n [6] - Make request for overdraft");

    }

    private static void clientMenu() {
        System.out.println("What would you like to do:\n [1] - Link account to Branch\n [2] - Approve overdraft\n [3] - Reject overdraft");


    }
}
