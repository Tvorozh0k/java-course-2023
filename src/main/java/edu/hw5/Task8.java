package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task8 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * the string of odd (1, 3, 5, ...) length
     *
     * @param string The string
     * @return true, if condition is satisfied, else - false
     */
    public static boolean zeroOne1(String string) {
        return string.matches("^([01]{2})*[01]$");
    }

    /**
     * starts with 0 and odd (1, 3, 5, ...) length OR start with 1 and even (2, 4, 6, ...) length
     *
     * @param string The string
     * @return true, if condition is satisfied, else - false
     */
    public static boolean zeroOne2(String string) {
        return string.matches("(^0([01]{2})*$)|(^1([01]{2})*[01]$)");
    }

    /**
     * all strings without 11 and 111
     *
     * @param string The string
     * @return true, if condition is satisfied, else - false
     */
    public static boolean zeroOne3(String string) {
        return string.matches("^(?!111?$)[01]*$");
    }

    /**
     * every odd symbol (indexes: 1, 3, 5, ...) is 1
     * indexes start with 0
     * Example: 010101 -> true
     * Indexes: 012345 -> s[1], s[3], s[5] are 1
     *
     * @param string The string
     * @return true, if condition is satisfied, else - false
     */
    public static boolean zeroOne4(String string) {
        // пустая строка, получается, должна подходить
        return string.matches("^([01](1[01])*1*)?$");
    }

    /**
     * count of zeroes >= 2, count of ones <= 1
     *
     * @param string The string
     * @return true, if condition is satisfied, else - false
     */
    public static boolean zeroOne5(String string) {
        // 1. (00 ...) OR 1 (00 ...)
        // 2. 01 (0 ...)
        // 3. (00 ...) 1 ( ...)
        return string.matches("(^1?0{2,}$)|(^010+$)|(^0{2,}10*$)");
    }

    public static void main(String[] args) {
        LOGGER.info(zeroOne1("0"));
        LOGGER.info(zeroOne1("1"));
        LOGGER.info(zeroOne1("000"));
        LOGGER.info(zeroOne1("111"));
        LOGGER.info(zeroOne1("00000"));
        LOGGER.info(zeroOne1("11111"));

        LOGGER.info(zeroOne1(""));
        LOGGER.info(zeroOne1("00"));
        LOGGER.info(zeroOne1("11"));
        LOGGER.info(zeroOne1("0000"));
        LOGGER.info(zeroOne1("1111"));

        LOGGER.info(zeroOne2("0"));
        LOGGER.info(zeroOne2("010"));
        LOGGER.info(zeroOne2("01010"));
        LOGGER.info(zeroOne2("10"));
        LOGGER.info(zeroOne2("1010"));
        LOGGER.info(zeroOne2("101010"));

        LOGGER.info(zeroOne2(""));
        LOGGER.info(zeroOne2("00"));
        LOGGER.info(zeroOne2("0011"));
        LOGGER.info(zeroOne2("001100"));
        LOGGER.info(zeroOne2("1"));
        LOGGER.info(zeroOne2("100"));
        LOGGER.info(zeroOne2("10011"));

        LOGGER.info(zeroOne3(""));
        LOGGER.info(zeroOne3("0"));
        LOGGER.info(zeroOne3("1"));
        LOGGER.info(zeroOne3("01"));
        LOGGER.info(zeroOne3("10"));
        LOGGER.info(zeroOne3("000"));
        LOGGER.info(zeroOne3("101"));
        LOGGER.info(zeroOne3("0000"));
        LOGGER.info(zeroOne3("1111"));
        LOGGER.info(zeroOne3("1010"));

        LOGGER.info(zeroOne3("11"));
        LOGGER.info(zeroOne3("111"));

        LOGGER.info(zeroOne4(""));
        LOGGER.info(zeroOne4("0"));
        LOGGER.info(zeroOne4("1"));
        LOGGER.info(zeroOne4("01"));
        LOGGER.info(zeroOne4("11"));
        LOGGER.info(zeroOne4("010"));
        LOGGER.info(zeroOne4("011"));
        LOGGER.info(zeroOne4("0101"));

        LOGGER.info(zeroOne4("00"));
        LOGGER.info(zeroOne4("10"));
        LOGGER.info(zeroOne4("000"));
        LOGGER.info(zeroOne4("001"));
        LOGGER.info(zeroOne4("01001"));

        LOGGER.info(zeroOne5("00"));
        LOGGER.info(zeroOne5("000"));
        LOGGER.info(zeroOne5("001"));
        LOGGER.info(zeroOne5("010"));
        LOGGER.info(zeroOne5("100"));

        LOGGER.info(zeroOne5(""));
        LOGGER.info(zeroOne5("0"));
        LOGGER.info(zeroOne5("1"));
        LOGGER.info(zeroOne5("01"));
        LOGGER.info(zeroOne5("10"));
        LOGGER.info(zeroOne5("11"));
        LOGGER.info(zeroOne5("011"));
        LOGGER.info(zeroOne5("101"));
        LOGGER.info(zeroOne5("110"));
        LOGGER.info(zeroOne5("111"));
    }
}
