package ferdy.database.ferdy.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {
    private static HikariDataSource dataSource;
    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/belajar-database");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60_000);
        hikariConfig.setMaxLifetime(10*60_000);

        dataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
