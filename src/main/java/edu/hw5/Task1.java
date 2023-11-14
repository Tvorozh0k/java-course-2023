package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * How much time visitors spend on average per session
     *
     * @param sessions Sessions of visitors
     * @return the average session time of visitors
     */
    static String averageTime(List<String> sessions) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        int sum = 0;

        for (var str : sessions) {
            var times = str.split(" - ");

            if (times.length != 2) {
                throw new IllegalArgumentException("Ошибка: сессия посетителя должна иметь вид: гггг-мм-дд, чч:мм - гггг-мм-дд, чч:мм");
            }

            LocalDateTime begin;
            LocalDateTime end;

            try {
                begin = LocalDateTime.parse(times[0], formatter);
                end = LocalDateTime.parse(times[1], formatter);
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка: сессия посетителя должна иметь вид: гггг-мм-дд, чч:мм - гггг-мм-дд, чч:мм");
            }

            int duration = (int) Duration.between(begin, end).toMinutes();

            if (duration <= 0) {
               throw new IllegalArgumentException("Ошибка: длительность сессии должна быть >= 1 минуты");
            }

            sum += duration;
        }

        int average = (int) Math.round(1.0 * sum / sessions.size());

        return String.format("%dч %dм", average / 60, average % 60);
    }

    public static void main(String[] args) {
        LOGGER.info(averageTime(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20")));
        LOGGER.info(averageTime(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51")));

        LOGGER.info(averageTime(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51")));
        LOGGER.info(averageTime(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51", "2022-03-12, 20:20 - 2022-03-12, 23:51")));
    }
}
