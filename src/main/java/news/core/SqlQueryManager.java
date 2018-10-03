package news.core;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class SqlQueryManager {
    private static SqlQueryManager ourInstance = new SqlQueryManager();


    public static SqlQueryManager getInstance() {
        return ourInstance;
    }


    private SqlQueryManager() {
    }


    /**
     *
     * @param identifier - For example: "dto/insert_article_keyword"
     * @return the query string; null if the SQL file could not be found
     */
    public String loadQuery(String identifier) {
        return loadQuery(identifier, new DatabaseConfig().getDatabaseSystem());
    }


    /**
     *
     * @param identifier - For example: "dto/insert_article_keyword"
     * @param databaseSystem - The used database system - for example, "monetdb"
     * @return the query string; null if the SQL file could not be found
     */
    public String loadQuery(String identifier, String databaseSystem) {
        String databaseSystemSpecificQueryPath = "sql/" + identifier + "." + databaseSystem + ".sql";
        String genericSqlQueryPath = "sql/" + identifier + ".sql";

        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream(databaseSystemSpecificQueryPath);
            if (in == null) {
                in = this.getClass().getClassLoader().getResourceAsStream(genericSqlQueryPath);
            }
            if (in == null) {
                System.err.println("SQL query file not found: " + identifier + " for " + databaseSystem);
                return null;
            }
            try {
                return IOUtils.toString(in);
            } catch (IOException ignored) {
                throw new RuntimeException("Unexpected error: loading a SQL query failed.");
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
