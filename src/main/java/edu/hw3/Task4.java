package edu.hw3;

import java.util.LinkedHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Convert to Roman
     * @param number The input number
     * @return The number in Roman
     */
    static String convertToRoman(int number) throws IllegalArgumentException {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Ошибка: число должно быть в диапазоне от 1 до 3999");
        }

        LinkedHashMap<Integer, String> romanSymbols = new LinkedHashMap<>();

        romanSymbols.put(1000, "M");
        romanSymbols.put(900, "CM");
        romanSymbols.put(500, "D");
        romanSymbols.put(400, "CD");
        romanSymbols.put(100, "C");
        romanSymbols.put(90, "XC");
        romanSymbols.put(50, "L");
        romanSymbols.put(40, "XL");
        romanSymbols.put(10, "X");
        romanSymbols.put(9, "IX");
        romanSymbols.put(5, "V");
        romanSymbols.put(4, "IV");
        romanSymbols.put(1, "I");

        StringBuilder result = new StringBuilder();

        for (int key : romanSymbols.keySet()) {
            // result += (number / key) * romanSymbols[key]
            result.append(romanSymbols.get(key).repeat(number / key));
            number %= key;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // convertToRoman(2) ➞ "II"
        LOGGER.info(convertToRoman(2));

        // convertToRoman(12) ➞ "XII"
        LOGGER.info(convertToRoman(12));

        // convertToRoman(16) ➞ "XVI"
        LOGGER.info(convertToRoman(16));

        LOGGER.info(convertToRoman(0));
    }
}
