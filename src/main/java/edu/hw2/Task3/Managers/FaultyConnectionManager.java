package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Managers.ConnectionManager;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
