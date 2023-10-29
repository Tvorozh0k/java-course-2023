package edu.hw3.Task7;

import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        TreeMap<String, String> tree = new TreeMap<>(new TreeMapComparator());
        tree.put(null, "test");
        tree.put("1", "test");

        LOGGER.info(tree.containsKey(null));
        LOGGER.info(tree.toString());
    }
}
