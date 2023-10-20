package ferdy.database.ferdy.validation;

import ferdy.database.ferdy.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ViewData {
    public static void getview(String uuid){
        System.out.println("Data list anda");
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM todo WHERE UUID = "+"'"+uuid+"'";
            ResultSet resultSet = statement.executeQuery(query);
            int num = 1;
            while (resultSet.next()){
                System.out.print(num++ + ". ");
                System.out.print("id = " + resultSet.getInt("id"));
                System.out.println(" todo = " + resultSet.getString("TODO"));
            }
        }catch (SQLException e){
        e.printStackTrace();
        }

    }
}
