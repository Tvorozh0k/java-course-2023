package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Connections.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();

    public void execute(String command) {
        LOGGER.info(String.format("%s выполнилась успешно", command));
    }

    @Override
    public void close() {

    }
}
