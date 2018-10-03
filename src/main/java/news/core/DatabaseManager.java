package news.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getConnection() {
        return getConnection(new DatabaseConfig());
    }


    public static Connection getConnection(DatabaseConfig config) {
        System.out.println("Connecting to database: " + config.getJdbcUrl());

        try {
            Class.forName(config.getDatabaseDriver());
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver \"" + config.getDatabaseDriver() + "\" not found.");
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getJdbcUrl(), config.getUser(), config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            return connection;
        } else {
            String errMsg = "Failed to make connection!";
            System.err.println(errMsg);
            throw new RuntimeException(errMsg);
        }
    }
}
