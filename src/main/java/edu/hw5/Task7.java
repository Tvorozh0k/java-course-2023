package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task7 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * 3 or more ones or zeros. 3rd symbol must be 0
     *
     * @param string The string
     * @return true,if condition is satisfied, else - false
     */
    public static boolean zeroOne1(String string) {
        return string.matches("^[01]{2}0[01]*$");
    }

    /**
     * starts and ends with the same symbol: 0 or 1
     *
     * @param string The string
     * @return true,if condition is satisfied, else - false
     */
    public static boolean zeroOne2(String string) {
        // 0 + [ (последовательность 0 и 1) + 0 ] (то, что в квадратных скобках, может быть, а может и нет)
        // 1 + [ (последовательность 0 и 1) + 1 ] (то, что в квадратных скобках, может быть, а может и нет)
        return string.matches("^(0([01]*0)?)|(1([01]*1)?)$");
    }

    /**
     * size 1, 2 or 3
     *
     * @param string The string
     * @return true,if condition is satisfied, else - false
     */
    public static boolean zeroOne3(String string) {
        return string.matches("^[01]{1,3}$");
    }

    public static void main(String[] args) {
        LOGGER.info(zeroOne1("0000"));
        LOGGER.info(zeroOne1("0001"));
        LOGGER.info(zeroOne1("000"));
        LOGGER.info(zeroOne1("010"));
        LOGGER.info(zeroOne1("100"));
        LOGGER.info(zeroOne1("110"));

        LOGGER.info(zeroOne1("00"));
        LOGGER.info(zeroOne1("0"));
        LOGGER.info(zeroOne1("001"));
        LOGGER.info(zeroOne1(""));

        LOGGER.info(zeroOne2("0"));
        LOGGER.info(zeroOne2("1"));
        LOGGER.info(zeroOne2("000"));
        LOGGER.info(zeroOne2("010"));
        LOGGER.info(zeroOne2("0101010"));
        LOGGER.info(zeroOne2("101"));
        LOGGER.info(zeroOne2("111"));
        LOGGER.info(zeroOne2("1010101"));

        LOGGER.info(zeroOne2(""));
        LOGGER.info(zeroOne2("01"));
        LOGGER.info(zeroOne2("10"));
        LOGGER.info(zeroOne2("100"));
        LOGGER.info(zeroOne2("011"));

        LOGGER.info(zeroOne3("0"));
        LOGGER.info(zeroOne3("1"));
        LOGGER.info(zeroOne3("00"));
        LOGGER.info(zeroOne3("01"));
        LOGGER.info(zeroOne3("10"));
        LOGGER.info(zeroOne3("11"));
        LOGGER.info(zeroOne3("000"));
        LOGGER.info(zeroOne3("111"));
        LOGGER.info(zeroOne3("101"));

        LOGGER.info(zeroOne3(""));
        LOGGER.info(zeroOne3("0000"));
        LOGGER.info(zeroOne3("1111"));
        LOGGER.info(zeroOne3("1010"));
    }
}
