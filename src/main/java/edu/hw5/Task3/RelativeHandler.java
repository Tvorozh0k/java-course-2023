package edu.hw5.Task3;

import java.time.LocalDate;

public class RelativeHandler implements DateHandler {
    public LocalDate parseDate(String str) {
        switch (str) {
            case "today" -> {
                return LocalDate.now();
            }
            case "day before yesterday" -> {
                return LocalDate.now().minusDays(2);
            }
            case "yesterday" -> {
                return LocalDate.now().minusDays(1);
            }
            case "tomorrow" -> {
                return LocalDate.now().plusDays(1);
            }
            case "day after tomorrow" -> {
                return LocalDate.now().plusDays(2);
            }
            default -> {
                var input = str.split(" ");

                if (input.length != 3) {
                    return null;
                }

                try {
                    int days = Integer.parseInt(input[0]);

                    if (days == 1 && str.endsWith("day ago")) {
                        return LocalDate.now().minusDays(1);
                    }

                    if (days > 0 && str.endsWith("days ago")) {
                        return LocalDate.now().minusDays(days);
                    }

                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }
}
