package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Get the duration of the video in seconds
     * @param str The duration of the video in format mm:ss
     * @return The duration of the video in seconds or -1 in case of incorrect input string
     */
    static int minutesToSeconds(String str) {
        // The format is mm:ss
        if (!str.matches("\\d{2,8}:[0-5][0-9]")) {
            return -1;
        }

        int MAX_MINUTES = Integer.MAX_VALUE / 60;
        int MAX_SECONDS = Integer.MAX_VALUE % 60;

        String[] time = str.split(":");

        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);

        // Integer value result will be out of range (35791395:10)
        if (minutes > MAX_MINUTES) {
            return -1;
        }

        // Integer value result will be out of range (35791394:08)
        if (minutes == MAX_MINUTES && seconds > MAX_SECONDS) {
            return -1;
        }

        return 60 * minutes + seconds;
    }

    public static void main(String[] args) {
        // minutesToSeconds("01:00") -> 60
        LOGGER.info(minutesToSeconds("01:00"));

        // minutesToSeconds("13:56") -> 836
        LOGGER.info(minutesToSeconds("13:56"));

        // minutesToSeconds("10:60") -> -1
        LOGGER.info(minutesToSeconds("10:60"));
    }
}
