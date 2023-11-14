package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if password contains any of the symbols [~ ! @ # $ % ^ & * |]
     *
     * @param password The password
     * @return true, if password is valid, else - false
     */
    public static boolean isValidPassword(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }

    public static void main(String[] args) {
        LOGGER.info(isValidPassword("lol!"));
        LOGGER.info(isValidPassword("!lol"));
        LOGGER.info(isValidPassword("l!ol"));
        LOGGER.info(isValidPassword("lol"));
    }
}
