package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if s is the subsequence of t
     *
     * @param t The string
     * @return true, if s is the subsequence of t, else - false
     */
    public static boolean isSubsequence(String s, String t) {
        return t.matches(".*" + String.join(".*", s.split("")) + ".*");
    }

    public static void main(String[] args) {
        LOGGER.info(isSubsequence("abc", "abc"));
        LOGGER.info(isSubsequence("abc", "0a0b0c0"));
        LOGGER.info(isSubsequence("abc", "0a0b00"));
        LOGGER.info(isSubsequence("", "0a0b00"));
        LOGGER.info(isSubsequence("a", "0a0b00"));
    }
}
