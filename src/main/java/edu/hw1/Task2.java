package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Count digits in number
     * @param number The input number
     * @return The count of digits of input number
     */
    static int countDigits(int number) {
        int result = (number == 0) ? 1 : 0;

        while (number != 0) {
            ++result;
            number /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        // countDigits(4666) -> 4
        LOGGER.info(countDigits(4666));

        // countDigits(544) -> 3
        LOGGER.info(countDigits(544));

        // countDigits(0) -> 1
        LOGGER.info(countDigits(0));

        // countDigits(-544) -> 3
        LOGGER.info(countDigits(-544));

        // countDigits(-4666) -> 4
        LOGGER.info(countDigits(-4666));
    }
}
