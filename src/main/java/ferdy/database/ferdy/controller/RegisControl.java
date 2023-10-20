package ferdy.database.ferdy.controller;

import ferdy.database.ferdy.Service.MenuLogin;
import ferdy.database.ferdy.Service.Register;
import ferdy.database.ferdy.connection.ConnectionUtil;
import ferdy.database.ferdy.scanner.ScannerUtilInfo;
import ferdy.database.ferdy.temp.CheckingNotNull;
import ferdy.database.ferdy.temp.Temporary;
import ferdy.database.ferdy.validation.LoginValidation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisControl {
    public static void getRegis(){
       boolean Valid = Temporary.getLoop();
       if (Valid){
           System.out.println("form Registerasi");
           System.out.println("===================");
           String fristname = CheckingNotNull.getNotnull("Masukan Nama Depan Anda");
           String lastName = CheckingNotNull.getNotnull("Masukan Nama Belakang Anda");
           String britday  = CheckingNotNull.getNotnull("Masukan Tgl Lahir Anda");
           String number = Temporary.getNumber();
           String email = Temporary.getMail();
           String username = CheckingNotNull.getNotnull("Masukan Username Anda");
           String password = Temporary.getEncripsi();
           boolean isValid = LoginValidation.getDataKey(email,number);
           if (isValid){
               LocalDate localDate = LocalDate.now();
               Register register = new Register(fristname,lastName,username,password,britday,number,email,localDate);
               try {
                   UUID uuid = UUID.randomUUID();
                   Connection connection = ConnectionUtil.getDataSource().getConnection();
                   Statement statement = connection.createStatement();
                   String sqlEmail = "INSERT INTO `add` (`email`,`number`,`UUID`) " +
                           "VALUES ('"+register.getEmail()+"','"+register.getNumber()+"','"+uuid+"');";

                   String sql =" INSERT INTO `register` " +
                           "( `first name`, `last name`, `username`, `password`, `britday`, `day login`,`UUID`) " +
                           "VALUES (" +
                           "'"
                           +register.getFristName()+"', '"
                           +register.getLasrName()+"', '"
                           +register.getUsername()+"', '"
                           +register.getPassword()+"', '"
                           +register.getBritday()+"', '"
                           +register.getDayLogin()+"','"+uuid+"')";
                   statement.executeUpdate(sql);
                   statement.executeUpdate(sqlEmail);
                   statement.close();
                   connection.close();
                   MenuLogin.diplayLogin(register.getUsername(), register.getPassword());
               }catch (SQLException exception){
                   exception.printStackTrace();
               }
           }else {
               System.out.println("email anda sudah terdaftar/no hp anda sudah terdaftar");
           }
       }
    }
}
