package me.rybakov.laba5.Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/me/rybakov/laba5/Task1/task1.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}