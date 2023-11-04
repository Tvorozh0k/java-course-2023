package edu.hw3.Task8;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(numbers);

        while (iterator.hasNext()) {
            Integer element = iterator.next();
            LOGGER.info(element);
        }
    }
}
