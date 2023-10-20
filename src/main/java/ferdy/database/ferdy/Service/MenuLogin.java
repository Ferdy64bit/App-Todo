package ferdy.database.ferdy.Service;

import com.mysql.cj.log.Log;
import ferdy.database.ferdy.connection.ConnectionUtil;
import ferdy.database.ferdy.controller.LoginControl;
import ferdy.database.ferdy.controller.RegisControl;
import ferdy.database.ferdy.temp.CheckingNotNull;
import ferdy.database.ferdy.validation.InsertTodo;
import ferdy.database.ferdy.validation.LupaPwValidate;
import ferdy.database.ferdy.validation.ViewData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuLogin {
    public static void diplayLogin(String username, String password){
        String choice;

        do {
            String uuid =  InsertTodo.getUuid(username,password,"register","username","password","UUID");
            System.out.println("Selamat datang");
            System.out.println("1. tambah data");
            System.out.println("2. edit data");
            System.out.println("3. hapus data");
            System.out.println("4. lihat data");
            System.out.println("0. keluar");
            choice = CheckingNotNull.getNotnull("pilih");
            if (choice.equals("1")){
                String todo = CheckingNotNull.getNotnull("masukan list anda");
                InsertTodo.insertTodoList(todo,uuid);
                System.out.println("data berhasil di inputkan" + todo);
            } else if (choice.equals("2")) {
                String masukan = CheckingNotNull.getNotnull("masukan id todo yang ingin diubah");
                String id = InsertTodo.getUuid(masukan,uuid,"todo","id","UUID","id");
                if (id.isEmpty()){
                    System.out.println("id tidak di temukan");
                }else {
                    System.out.println("data di temukan");
                    String velue  = CheckingNotNull.getNotnull("masukan todo anada");
                    int con = Integer.parseInt(id);
                    LupaPwValidate.getUpdate("todo","TODO",velue,con);
                }
            } else if (choice.equals("3")) {
                String pot = CheckingNotNull.getNotnull("masukan id todo yang ingin di hapus");
                String id = InsertTodo.getUuid(pot,uuid,"todo","id","UUID","id");
                if (id.isEmpty()){
                    System.out.println("id tidak di temukan");
                }else {
                    System.out.println("data di temukan");
                    InsertTodo.getDeleted(pot);
                    System.out.println("data berhasil di hapus");
                }
            } else if (choice.equals("4")) {
                ViewData.getview(uuid);
            } else if (choice.equals("0")) {
                System.out.println("exit");
                choice = "0";
            } else {
                System.out.println("not found");
            }

        }while (!choice.equals("0"));
    }
}
