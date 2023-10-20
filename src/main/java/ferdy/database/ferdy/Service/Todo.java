package ferdy.database.ferdy.Service;

import ferdy.database.ferdy.connection.ConnectionUtil;
import ferdy.database.ferdy.temp.CheckingNotNull;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Todo {
    private String todo;

    public Todo() {
    }

    public Todo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
    public static void todo(){

    };
    public static void getTodoList(String uuid){
        String add = CheckingNotNull.getNotnull("Masukan todo Anda");
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `todo` (`TODO`, `UUID`) VALUES ('"+uuid+"', '"+uuid+"');";
        }catch (SQLException e){

        }
    }

}
