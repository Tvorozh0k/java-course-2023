package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Parse date from string
     *
     * @param string String with date info
     * @return The LocalDate or null
     */
    public static Optional<LocalDate> parseDate(String string) {
        return Stream.of(new DayMonthYearHandler(), new RelativeHandler())
            .map(elem -> elem.parseDate(string))
            .filter(Objects::nonNull)
            .findAny();
    }

    public static void main(String[] args) {
        LOGGER.info(parseDate("2020-10-10"));
        LOGGER.info(parseDate("2020-12-2"));
        LOGGER.info(parseDate("1/3/1976"));
        LOGGER.info(parseDate("1/3/20"));

        LOGGER.info(parseDate("tomorrow"));
        LOGGER.info(parseDate("today"));
        LOGGER.info(parseDate("yesterday"));
        LOGGER.info(parseDate("1 day ago"));
        LOGGER.info(parseDate("2234 days ago"));
    }
}
