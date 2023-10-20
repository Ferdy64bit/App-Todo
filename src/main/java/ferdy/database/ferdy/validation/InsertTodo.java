package ferdy.database.ferdy.validation;

import ferdy.database.ferdy.Service.Todo;
import ferdy.database.ferdy.connection.ConnectionUtil;

import java.sql.*;

public class InsertTodo {
    public static String getUuid(String username, String password,String tabelName,String Coluser,String Colpw,String retrnValue){
        String isValid = "";

        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = " SELECT * FROM `"+tabelName+"` WHERE "+Coluser+" = ? AND "+Colpw+" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                isValid = resultSet.getString(retrnValue);
            }
            preparedStatement.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return isValid;
    }
    public static String insertTodoList(String todo, String UUID){
        String tes = "";
    try {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO `todo` (`TODO`,`UUID`) VALUES ('"+ todo +"','"+UUID+"')";
        statement.executeUpdate(sql);
        tes = todo;
        statement.close();
        connection.close();
    }catch (SQLException e){
        e.printStackTrace();
    }
    return tes;
    }

    public static void getDeleted(String id){
        try{
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM `todo` WHERE `todo`.`id` = "+id;
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
