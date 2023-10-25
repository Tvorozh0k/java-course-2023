package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Task3 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Finding a minimum element of the array
     * @param mas Not empty array
     * @return the minimum element of the array
     */
    static int arrayMin(int @NotNull [] mas) throws IllegalArgumentException {
        if (mas.length == 0) {
            throw new IllegalArgumentException("mas is empty");
        }

        int min = mas[0];

        for (int i = 1; i < mas.length; ++i) {
            min = Math.min(min, mas[i]);
        }

        return min;
    }

    /**
     * Finding a maximum element of the array
     * @param mas Not empty array
     * @return the maximum element of the array
     */
    static int arrayMax(int @NotNull [] mas) throws IllegalArgumentException {
        if (mas.length == 0) {
            throw new IllegalArgumentException("mas is empty");
        }

        int max = mas[0];

        for (int i = 1; i < mas.length; ++i) {
            max = Math.max(max, mas[i]);
        }

        return max;
    }

    /**
     * Check if the first array is nestable or not
     * @param mas1 The first array
     * @param mas2 The second array
     * @return <code>true</code> if the first array is nestable, else <code>false</code>
     */
    static boolean isNestable(int[] mas1, int[] mas2) throws IllegalArgumentException {
        return arrayMin(mas2) < arrayMin(mas1) && arrayMax(mas1) < arrayMax(mas2);
    }

    public static void main(String[] args) throws IllegalArgumentException {
        // min(mas2) = 0 < min(mas1) = 1 AND max(mas1) = 4 < max(mas2) = 6 ===> TRUE
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));

        // min(mas2) = 0 < min(mas1) = 1 AND max(mas1) = 3 < max(mas2) = 4 ===> TRUE
        LOGGER.info(isNestable(new int[] {3, 1}, new int[] {4, 0}));

        // min(mas2) = 8 = min(mas1) = 8 AND max(mas1) = 9 = max(mas2) = 9 ===> FALSE
        LOGGER.info(isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));

        // min(mas2) = 2 > min(mas1) = 1 AND max(mas1) = 4 > max(mas2) = 3 ===> FALSE
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }
}
