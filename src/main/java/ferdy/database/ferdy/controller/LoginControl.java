package ferdy.database.ferdy.controller;

import com.mysql.cj.log.Log;
import ferdy.database.ferdy.Service.MenuLogin;
import ferdy.database.ferdy.temp.CheckingNotNull;
import ferdy.database.ferdy.temp.Temporary;
import ferdy.database.ferdy.validation.InsertTodo;
import ferdy.database.ferdy.validation.LoginValidation;
import ferdy.database.ferdy.validation.LupaPwValidate;

import java.util.Base64;
import java.util.Random;

public class LoginControl {
        public static void getLogin() {
            boolean isValidate = Temporary.getLoop();
            if (isValidate){
                String username = CheckingNotNull.getNotnull("Masukan Username Anda");
                String convert = Temporary.getUncode();
                boolean isValid = LoginValidation.getLogin(username, convert, "register", "username", "password");
                if (isValid) {
                    System.out.println("succes fully");
                    MenuLogin.diplayLogin(username,convert);
                } else {
                    System.out.println("data tidak di temukan");
                }
            }
        }

        public static void getLupapassword(){
            boolean isValidate = Temporary.getLoop();
            if (isValidate){
                String email = CheckingNotNull.getNotnull("masukan email anda");
                String number = CheckingNotNull.getNotnull("masukan no hp anda");
                boolean isValid = LoginValidation.getLogin(email,number,"add","email","number");
                int valid = LoginValidation.geOtp();
                System.out.println(valid);
                if (isValid){
                    boolean checking = false;
                    do {
                        String otp = CheckingNotNull.getNotnull("masukan otp yang di kirimkan");
                        Integer cek = Integer.parseInt(otp);
                        if (cek.equals(valid)){
                            System.out.println("silahkan ubah kata sandi / username anda");
                            String choice = CheckingNotNull.getNotnull("1. username / 2. password");
                            if (choice.equals("1")){
                                String oldUser = CheckingNotNull.getNotnull("masukan username lama anda");
                                String getId= LupaPwValidate.getInfo(oldUser,"register","username");
//                                update username
                                String username = CheckingNotNull.getNotnull("Masukan username baru anda");
                                int id = Integer.parseInt(getId);
                                LupaPwValidate.getUpdate("register","username",username,id);
                                break;
                            } else if (choice.equals("2")) {
//                                mengambil id
                                String oldUser = CheckingNotNull.getNotnull("pasword lama anda");
                                String encode = Base64.getEncoder().encodeToString(oldUser.getBytes());
                                String getId= LupaPwValidate.getInfo(encode,"register","password");
//                                update password
                                int id = Integer.parseInt(getId);
                                String encode2 = Temporary.getEncripsi();
                                LupaPwValidate.getUpdate("register","password",encode2,id);
                                break;

                            }else {
                                System.out.println("notfound");
                            }
                            System.out.println("silahkan masuk kembali ke menu login");
                        }
                    }while (!checking);
                }else {
                    System.out.println("data not found");
                }
            }
        }
}
