package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Kaprekar's routine
     * @param number The input number
     * @return The number of steps to manage to number 6174
     */
    static int countK(int number) throws IllegalArgumentException {
        if (!(1000 < number && number <= 9999)) {
            throw new IllegalArgumentException("Ошибка: число должно быть четырехзначным и больше 1000");
        }

        int result = 0;

        String strNumber = Integer.toString(number);

        boolean isSameDigits = true;

        for (int i = 0; i < 3 && isSameDigits; ++i) {
            isSameDigits = strNumber.charAt(i) == strNumber.charAt(i + 1);
        }

        if (isSameDigits) {
            throw new IllegalArgumentException("Ошибка: в числе все цифры не должны быть одинаковыми");
        }

        while (number != 6174) {
            char[] digits = new char[4];

            for (int i = 0; i < 4; ++i) {
                digits[i] = (char) ('0' + (number % 10));
                number /= 10;
            }

            Arrays.sort(digits);
            String newNumber1 = new String(digits);
            String newNumber2 = new StringBuilder(newNumber1).reverse().toString();

            number = Integer.parseInt(newNumber2) - Integer.parseInt(newNumber1);

            ++result;
        }

        return result;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        LOGGER.info(countK(1112));
    }
}
