package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayMonthYearHandler implements DateHandler {

    public LocalDate parseDate(String date) {
        try {
            if (date.contains("-")) {
                // 1. year[2 or 4]-month[1 or 2]-day[1 or 2]
                return LocalDate.parse(date, DateTimeFormatter.ofPattern("[uuuu-MM-dd][uuuu-MM-d][uuuu-M-dd][uuuu-M-d]"
                    + "[uu-MM-dd][uu-MM-d][uu-M-dd][uu-M-d]"));
            }

            // 2. day[1 or 2]-month[1 or 2]-year[2 or 4]
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("[dd/MM/uuuu][d/MM/uuuu][dd/M/uuuu][d/M/uuuu]"
                + "[dd/MM/uu][d/MM/uu][dd/M/uu][d/M/uu]"));
        } catch (Exception e) {
            return null;
        }
    }
}
