package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        if (Math.random() < 0.2) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
