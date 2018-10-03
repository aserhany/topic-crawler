package news.core;

import java.util.Properties;


public class DatabaseConfig {
    private String host;
    private String port;
    private String user;
    private String password;
    private String databaseName;
    private String databaseSystem;
    private String databaseDriver;
    private int maxPoolSize;


    public DatabaseConfig() {
        Properties config = Main.getConfiguration().getConfig();
        this.host = config.getProperty("DB_HOST");
        this.port = config.getProperty("DB_PORT");
        this.user = config.getProperty("DB_USER");
        this.password = config.getProperty("DB_PASSWORD");
        this.databaseName = config.getProperty("DB_NAME");
        this.databaseSystem = config.getProperty("DB_DATABASE_SYSTEM");
        this.databaseDriver = config.getProperty("DB_DATABASE_DRIVER");
        this.maxPoolSize = Integer.parseInt(config.getProperty("DB_MAX_POOL_SIZE"));
    }


    public String getHost() {
        return host;
    }


    public DatabaseConfig setHost(String host) {
        this.host = host;
        return this;
    }


    public String getPort() {
        return port;
    }


    public DatabaseConfig setPort(String port) {
        this.port = port;
        return this;
    }


    public String getUser() {
        return user;
    }


    public DatabaseConfig setUser(String user) {
        this.user = user;
        return this;
    }


    public String getPassword() {
        return password;
    }


    public DatabaseConfig setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getDatabaseName() {
        return databaseName;
    }


    public DatabaseConfig setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }


    public String getDatabaseSystem() {
        return databaseSystem;
    }


    public DatabaseConfig setDatabaseSystem(String databaseSystem) {
        this.databaseSystem = databaseSystem;
        return this;
    }


    public String getDatabaseDriver() {
        return databaseDriver;
    }


    public DatabaseConfig setDatabaseDriver(String databaseDriver) {
        this.databaseDriver = databaseDriver;
        return this;
    }


    public int getMaxPoolSize() {
        return maxPoolSize;
    }


    public DatabaseConfig setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        return this;
    }


    public String getJdbcUrl() {
        return "jdbc:" + this.getDatabaseSystem() + "://" + this.getHost() + ":" + this.getPort()
                + "/" + this.getDatabaseName();
    }
}
