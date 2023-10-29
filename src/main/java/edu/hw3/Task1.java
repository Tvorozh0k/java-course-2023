package edu.hw3;

import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Atbash Cipher
     * @param str The message
     * @return The encrypted message
     */
    static String atbash(String str) {
        // The encrypted string (now empty)
        StringBuilder result = new StringBuilder();

        // HashMap, which changes the letters of the English language
        HashMap<Character, Character> encrypt = new HashMap<>();

        // Lowercase letters
        for (char sym = 'a'; sym <= 'z'; ++sym) {
            encrypt.put(sym, (char) ('z' - sym + 'a'));
        }

        // Uppercase letters
        for (char sym = 'A'; sym <= 'Z'; ++sym) {
            encrypt.put(sym, (char) ('Z' - sym + 'A'));
        }

        // Build the encrypted string
        for (int i = 0; i < str.length(); ++i) {
            char sym = str.charAt(i);
            result.append(encrypt.getOrDefault(sym, sym));
        }

        return new String(result);
    }

    public static void main(String[] args) {
        // atbash("Hello world!") -> "Svool dliow!"
        LOGGER.info(atbash("Hello world!"));

        // atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler") ->
        // "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
        LOGGER.info(atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"));
    }
}
