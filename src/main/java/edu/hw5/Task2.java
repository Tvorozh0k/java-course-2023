package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * All friday 13 in the year
     *
     * @param year The year
     * @return All days which is friday 13
     */
    static List<String> allFriday13(int year) throws IllegalArgumentException {
        if (year <= 0) {
            throw new IllegalArgumentException("Ошибка: год должен быть положительным");
        }

        // The result (now is empty)
        List<String> result = new ArrayList<>();

        LocalDate date = LocalDate.of(year, Month.JANUARY, 13);

        // Check every month
        for (; date.getYear() == year; date = date.plusMonths(1)) {
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result.add(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
            }
        }

        return result;
    }

    /**
     * Find next friday 13
     *
     * @param date The date
     * @return The next friday 13
     */
    static LocalDate nextFriday13(LocalDate date) {
        // Next 13-th date
        date = date.withDayOfMonth(13).plusMonths((date.getDayOfMonth() <= 13) ? 0 : 1);

        // Next friday 13
        while (!date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            date = date.plusMonths(1);
        }

        return date;
    }

    public static void main(String[] args) {
        LOGGER.info(allFriday13(1925));
        LOGGER.info(allFriday13(2023));

        LOGGER.info(nextFriday13(LocalDate.of(2023, 10, 12)));
        LOGGER.info(nextFriday13(LocalDate.of(2023, 10, 13)));
        LOGGER.info(nextFriday13(LocalDate.of(2023, 10, 14)));
    }
}
