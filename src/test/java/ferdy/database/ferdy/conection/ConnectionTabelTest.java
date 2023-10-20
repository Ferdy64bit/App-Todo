package ferdy.database.ferdy.conection;

import ferdy.database.ferdy.connection.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTabelTest {
    @Test
    void tabelDataTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                select * from `data`
                """;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("number"));
            System.out.println(resultSet.getString("email"));
        }
    }
}
