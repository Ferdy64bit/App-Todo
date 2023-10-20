package ferdy.database.ferdy.Service;

import com.mysql.cj.log.Log;
import ferdy.database.ferdy.controller.LoginControl;
import ferdy.database.ferdy.controller.RegisControl;
import ferdy.database.ferdy.temp.CheckingNotNull;

public class MainMenu {
    public static void display(){
        String choice;

        do {
            System.out.println("selamat datang di aplikasi kami");
            System.out.println("silahkan pilih menu di bawah ini");
            System.out.println("1. login");
            System.out.println("2. register");
            System.out.println("3. lupa password");
            System.out.println("0. Exit");


            choice = CheckingNotNull.getNotnull("pilih");
            if (choice.equals("1")){
                LoginControl.getLogin();
            } else if (choice.equals("2")) {
                RegisControl.getRegis();
            } else if (choice.equals("3")) {
                LoginControl.getLupapassword();
            } else if (choice.equals("0")) {
                System.out.println("exit");
                choice = "0";
            } else {
                System.out.println("not found");
            }
        }while (!choice.equals("0"));
    }
}
