package ferdy.database.ferdy.validation;

import com.mysql.cj.log.Log;
import ferdy.database.ferdy.connection.ConnectionUtil;
import ferdy.database.ferdy.temp.Temporary;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidationTest {
    @Test
    void tesValidation() {
        System.out.println(
                LoginValidation.getLogin("adminoke","1234","add","email","number")
        );
    }

    @Test
    void Test() throws SQLException  {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                UPDATE `register` SET `username` = 'admin' WHERE `register`.`id` = 1;
                """;
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
}
