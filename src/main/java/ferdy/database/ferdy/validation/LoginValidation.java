package ferdy.database.ferdy.validation;

import ferdy.database.ferdy.connection.ConnectionUtil;

import java.sql.*;

public class LoginValidation {
    public static Boolean getLogin(String username, String password,String tabelName,String Coluser,String Colpw){
        boolean isValid = false;

        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = " SELECT * FROM `"+tabelName+"` WHERE "+Coluser+" = ? AND "+Colpw+" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                isValid = true;
            }
            preparedStatement.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return isValid;
    }

    public static Boolean getDataKey(String email, String number){
        boolean isValid = true;

        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = """
                    SELECT * FROM `add`
                """;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String mail = resultSet.getString("email");
                String num = resultSet.getString("number");
                if (mail.equalsIgnoreCase(email)||num.equalsIgnoreCase(number)){
                    isValid = false;
                }

            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return isValid;
    }

    public static int geOtp(){
        double min=100000;
        double max = 999999;
        double range = max-min+1;
        int key = 0;
        key = (int) (Math.random()*range)+(int) min;
        return key;
    }

}
