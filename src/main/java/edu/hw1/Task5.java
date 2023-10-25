package edu.hw1;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if the number or its offsprings are palindrome or not
     * @param number The input number
     * @return <code>true</code> if the number or its offsprings are palindrome, else <code>false</code>
     */
    static boolean isPalindromeDescendant(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("number must be positive");
        }

        // The length of palindrome must be > 1
        if (number < 10) {
            return false;
        }

        // Get the list of digits of input number

        ArrayList<Integer> digits = new ArrayList<>();

        while (number != 0) {
            digits.add(number % 10);
            number /= 10;
        }

        // Check if the number is palindrome

        int len = digits.size();
        boolean isPalindrome = true;

        for (int i = 0; i < len - 1 - i && isPalindrome; ++i) {
            isPalindrome = digits.get(i).equals(digits.get(len - i - 1));
        }

        if (isPalindrome) {
            return true;
        }

        // Create the offspring of input number

        ArrayList<Integer> newDigits = new ArrayList<>();

        if (len % 2 == 1) {
            newDigits.add(digits.get(0));
        }

        for (int i = len % 2; i < len; i += 2) {
            newDigits.add(digits.get(i) + digits.get(i + 1));
        }

        int newNumber = 0;
        int ten = 1;

        for (var num : newDigits) {
            newNumber += num * ten;
            ten *= (num >= 10) ? 100 : 10;
        }

        return isPalindromeDescendant(newNumber);
    }

    public static void main(String[] args) throws IllegalArgumentException {
        // isPalindromeDescendant(12345678) -> false // 12345678 -> 371115 -> 1026 -> 18 -> 9
        LOGGER.info(isPalindromeDescendant(12345678));

        // isPalindromeDescendant(123) -> true // 123 -> 33
        LOGGER.info(isPalindromeDescendant(123));

        // isPalindromeDescendant(12321) -> true // 12321
        LOGGER.info(isPalindromeDescendant(12321));

        // isPalindromeDescendant(1000) -> false // 1000 -> 10 -> 1
        LOGGER.info(isPalindromeDescendant(1000));

        // isPalindromeDescendant(12345) -> false // 12345 -> 375 -> 105 -> 15 -> 6
        LOGGER.info(isPalindromeDescendant(12345));

        // isPalindromeDescendant(11211230) -> true // 11211230 -> 2333 -> 56 -> 11
        LOGGER.info(isPalindromeDescendant(11211230));

        // isPalindromeDescendant(13001120) -> true // 13001120 -> 4022 ➞ 44
        LOGGER.info(isPalindromeDescendant(13001120));

        // isPalindromeDescendant(23336014) -> true // 23336014 -> 5665
        LOGGER.info(isPalindromeDescendant(23336014));

        // isPalindromeDescendant(11) -> true
        LOGGER.info(isPalindromeDescendant(11));
    }
}
