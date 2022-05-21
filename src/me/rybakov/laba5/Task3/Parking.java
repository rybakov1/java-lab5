package me.rybakov.laba5.Task3;

import java.time.Duration;
import java.time.LocalDateTime;

public class Parking {
    private final int id;
    private final LocalDateTime entryTime;
    private LocalDateTime outTime;

    public Parking(int id, LocalDateTime entryTime) {
        this.id = id;
        this.entryTime = entryTime;
    }

    public long ticketPrice() throws Exception {
        long minutes = Duration.between(entryTime, outTime).toMinutes();
        long total;

        if (minutes >= 1 && minutes <= 15) {
            total = 0;
        } else if (minutes >= 16 && minutes <= 30) {
            total = 120;
        } else if (minutes >= 31 && minutes <= 60) {
            total = 170;
        } else if (minutes >= 61 && minutes <= 90) {
            total = 220;
        } else if (minutes >= 91 && minutes <= 120) {
            total = 270;
        } else if (minutes >= 121 && minutes <= 150) {
            total = 320;
        } else if (minutes >= 151 && minutes <= 180) {
            total = 370;
        } else if (minutes > 180) {
            long halfHourCount = (int) Math.ceil((minutes - 180) / 30d);
            total = 370 + halfHourCount * 50;
        } else {
            throw new Exception("Wrong time!");
        }

        return total;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public int getId() {
        return id;
    }
}