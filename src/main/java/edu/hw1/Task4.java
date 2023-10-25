package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Function that fixes input string
     * @param str The string with message
     * @return A fixed string
     */
    static String fixString(String str) {
        int len = str.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len / 2 * 2; i += 2) {
            result.append(str.charAt(i + 1));
            result.append(str.charAt(i));
        }

        if (len % 2 != 0) {
            result.append(str.charAt(len - 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // fixString("123456") ➞ "214365"
        LOGGER.info("123456");

        // fixString("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
        LOGGER.info("hTsii  s aimex dpus rtni.g");

        // fixString("badce") ➞ "abcde"
        LOGGER.info("badce");

        // fixString("") ➞ ""
        LOGGER.info("");
    }
}
