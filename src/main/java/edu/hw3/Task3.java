package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Task3 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Counting elements frequencies
     *
     * @param list The input array of elements
     * @param <T>  The type of elements of the input list
     * @return The dictionary of elements frequencies
     */
    static <T> HashMap<T, Integer> freqDict(@NotNull ArrayList<T> list) {
        // The result (now is empty)
        HashMap<T, Integer> result = new HashMap<>();

        // 1. str not in text -> result[str] = 1
        // 2. str in text     -> result[str] += 1
        for (var elem : list) {
            result.merge(elem, 1, Integer::sum);
        }

        return result;
    }

    public static void main(String[] args) {
        // freqDict(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 2}
        LOGGER.info(freqDict(new ArrayList<>(List.of("a", "bb", "a", "bb"))));

        // freqDict(["this", "and", "that", "and"]) → {"that": 1, "and": 2, "this": 1}
        LOGGER.info(freqDict(new ArrayList<>(List.of("this", "and", "that", "and"))));

        // freqDict(["код", "код", "код", "bug"]) → {"код": 3, "bug": 1}
        LOGGER.info(freqDict(new ArrayList<>(List.of("код", "код", "код", "bug"))));

        // freqDict([1, 1, 2, 2]) → {1: 2, 2: 2}
        LOGGER.info(freqDict(new ArrayList<>(List.of(1, 1, 2, 2))));
    }
}
