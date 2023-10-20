package ferdy.database.ferdy.validation;

import ferdy.database.ferdy.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LupaPwValidate {
    public static String getInfo(String name, String tabel, String tabelName){
        String id="";
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM " + tabel;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String text = resultSet.getString(tabelName);
                if (text.equalsIgnoreCase(name)){
                    id = resultSet.getString("id");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return id;
    }


    public static void getUpdate(String Tabel,String colum,String value,int id){
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = "  UPDATE `"+Tabel+"` SET `"+colum+"` = '"+value+"' WHERE `"+Tabel+"`.`id` = "+id;;
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("succes fully");
        }catch (SQLException e){

        }
    }
}
