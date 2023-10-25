package edu.hw2.Task3;

import edu.hw2.Task3.Managers.FaultyConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        for (int i = 0; i < 10; ++i) {
            LOGGER.info(String.format("Test #%d", i + 1));

            PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
            executor.updatePackages();
        }
    }
}
