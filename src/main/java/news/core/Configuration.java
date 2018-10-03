package news.core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;

public class Configuration {

    private Properties config;
    private String environment;


    public Configuration() throws IOException {
        // Step 1: Read default configuration
        Properties defaultProps = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("data-manager-default.conf");
        defaultProps.load(in);

        // Step 2: Read environment variable
        // Environment variable NEWS_DB_HOST = Config variable DB_HOST
        Properties envProps = new Properties(defaultProps);
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if (envName.startsWith("NEWS_")) {
                String confName = envName.substring(5);
                String confValue = System.getenv(envName);
                envProps.setProperty(confName, confValue);
            }
        }

        config = envProps;

        // Determine the environment
        environment = config.getProperty("ENVIRONMENT");
    }


    public Configuration(Path pathToUserConfiguration) throws IOException {
        this();

        // Step 3: Read user specified configuration file
        Properties userProps = new Properties(this.config);
        InputStream in = Files.newInputStream(pathToUserConfiguration);
        userProps.load(in);

        config = userProps;
    }


    public Properties getConfig() {
        return config;
    }


    public boolean isDevelopment() {
        return "development".equals(environment);
    }


    public boolean isProduction() {
        return "production".equals(environment);
    }
}
