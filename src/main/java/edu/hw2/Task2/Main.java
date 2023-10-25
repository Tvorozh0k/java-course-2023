package edu.hw2.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        var rect = new Rectangle().setWidth(20).setHeight(10);

        LOGGER.info(String.format("S = %.2f", rect.area()));

        var square1 = new Square().setHeight(20).setHeight(10);

        LOGGER.info(String.format("S = %.2f", square1.area()));

        var square2 = new Square().setHeight(20);

        LOGGER.info(String.format("S = %.2f", square2.area()));
    }
}
