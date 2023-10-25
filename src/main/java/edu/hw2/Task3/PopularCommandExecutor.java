package edu.hw2.Task3;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Managers.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    private final static Logger LOGGER = LogManager.getLogger();

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Exception cause = null;

        for (int i = 0; i < maxAttempts; ++i) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (Exception e) {
                LOGGER.info("Не удалось выполнить команду");
                cause = e;
            }
        }

        for (var element : cause.getStackTrace()) {
            LOGGER.error(element.toString());
        }
    }
}
