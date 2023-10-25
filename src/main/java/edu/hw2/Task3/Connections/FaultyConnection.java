package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();

    public void execute(String command) throws ConnectionException {
        if (Math.random() < 0.2) {
            throw new ConnectionException();
        } else {
            LOGGER.info(String.format("%s выполнилась успешно", command));
        }
    }

    @Override
    public void close() {

    }
}
