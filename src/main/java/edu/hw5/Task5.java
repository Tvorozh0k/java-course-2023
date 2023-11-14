package edu.hw5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if car number exists
     *
     * @param number The car number
     * @return true, if car number exists, else - false
     */
    public static boolean isValidCarNumber(String number) {
        // Буквы, которые могут быть: А, В, Е, К, М, Н, О, Р, С, Т, У, Х
        // Регистрационный номер (между буквами): от 001 до 999
        // Код региона: среди двухзначных, видимо, заняты все, у некоторых регионов несколько позиций
        // Нельзя использовать (...00). В трехзначных нельзя использовать 0 в качестве 1-ой цифры
        return number.matches("[АВЕКМНОРСТУХ](?!000)\\d{3}[АВЕКМНОРСТУХ]{2}((?![1-9]?00)([1-9]?\\d{2}))");
    }

    public static void main(String[] args) {
        LOGGER.info(isValidCarNumber("А123ВЕ777"));
        LOGGER.info(isValidCarNumber("О777ОО177"));

        LOGGER.info(isValidCarNumber("А123ВЕ100"));
        LOGGER.info(isValidCarNumber("А123ВЕ101"));

        LOGGER.info(isValidCarNumber("123АВЕ777"));
        LOGGER.info(isValidCarNumber("А123ВГ77"));
        LOGGER.info(isValidCarNumber("А123ВЕ7777"));
    }
}
