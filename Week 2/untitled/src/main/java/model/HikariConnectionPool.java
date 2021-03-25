package model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPool {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public static final String DB_URL = "jdbc:mysql://localhost:3306";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "12345678";

    static {
        config.setJdbcUrl(DB_URL);
        config.setUsername(USER);
        config.setPassword(PASS);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(10);
        ds = new HikariDataSource(config);
    }

    private HikariConnectionPool() {

    }

    public static Connection getConnection() throws SQLException {
        System.out.println(ds.getMaximumPoolSize());
        return ds.getConnection();
    }
}
