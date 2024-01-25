package com.booleanuk.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileHandler {

    public static void writeToFile(String filename, ArrayList<Account> data) throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Account> readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Account>) ois.readObject();
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}