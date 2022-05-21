package me.rybakov.laba5.Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Task3 {
    public static void main(String[] args)  {
        HashMap<Integer, Parking> list_tickets = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/me/rybakov/laba5/Task3/task3.txt"))) {
            String s;

            if ((s = reader.readLine()) == null) {
                return;
            }
            int linesCount = Integer.parseInt(s);

            for (int i = 0; i < linesCount; i++) {
                if ((s = reader.readLine()) == null) {
                    return;
                }

                String[] text_line = s.split(" ");

                int ticket_type = Integer.parseInt(text_line[0]);
                String action_time = text_line[1];
                LocalDateTime converted_time = LocalDateTime.parse(action_time, DateTimeFormatter.ofPattern("uuuu-MM-dd.HH:mm:ss"));
                int ticket_id = Integer.parseInt(text_line[2]);

                if (ticket_type == 1) {
                    Parking ticket = new Parking(ticket_id, converted_time);
                    list_tickets.put(ticket_id, ticket);
                } else if (ticket_type == -1) {
                    Parking ticket = list_tickets.get(ticket_id);
                    ticket.setOutTime(converted_time);

                    System.out.println("id билета: " + ticket.getId() + ", сумма билета: " + ticket.ticketPrice());
                } else {
                    System.out.println("Такого тикета не существует: " + ticket_id);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}