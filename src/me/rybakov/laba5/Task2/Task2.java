package me.rybakov.laba5.Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> entries_list = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/me/rybakov/laba5/Task2/task2.txt"))) {
            String s;
            if ((s = reader.readLine()) == null) {
                return;
            }

            int count_lines = Integer.parseInt(s);
            for (int i = 0; i < count_lines; i++) {
                if ((s = reader.readLine()) == null) {
                    return;
                }
                String[] new_human = s.split(" ");

                int id_human = Integer.parseInt(new_human[0]);
                int int_auth = Integer.parseInt(new_human[1]);
                boolean is_Authorized;

                if (int_auth == 1) {
                    is_Authorized = true;
                } else if (int_auth == -1) {
                    is_Authorized = false;
                } else {
                    System.out.println("Статус входа неверный: " + id_human + ":" + int_auth);
                    break;
                }
                if (entries_list.containsKey(id_human) && entries_list.get(id_human) == is_Authorized) {
                    System.out.println("YES");
                    break;
                }
                entries_list.put(id_human, is_Authorized);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
