package ferdy.database.ferdy.temp;

import ferdy.database.ferdy.controller.RegisControl;
import ferdy.database.ferdy.scanner.ScannerUtilInfo;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temporary {
//    get mail
    public static String getMail(){

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        boolean isValid;
        String email;
        do {
            email = ScannerUtilInfo.input("Masukan Email Anda");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            isValid = matcher.matches();
            if (!isValid){
                System.out.println("exampale@gmail.com");
            }
        }while (isValid != true);
        return email;
    }
//    get number
    public static String getNumber(){
        String regex = "\\d+";//regex phone
        boolean isValid;
        String noHp;
        do {
            noHp = ScannerUtilInfo.input("Masukan No Hp Anda");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(noHp);
            isValid = matcher.matches();
            if (!isValid){
                System.out.println("field hanya beloh berisikan angka");
            }
        }while (isValid != true);
        return noHp;
    }

//    get pw

    public static String getEncripsi(){

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        System.out.println("pastikan password mengandunga charter,huruf besar dan kecil sertta angka");
        System.out.println("#Exampale123");

        String getToken = "";
        int stement = 1;
        do {

            String pw = ScannerUtilInfo.input("Masukan Password Anda");
            String pw1 = ScannerUtilInfo.input("Masukan kembali password Anda");

            if (pw.equals(pw1)){
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(pw);
                boolean isValid = matcher.matches();
                // Cetak hasil validasi
                if (isValid) {
                    String encode = Base64.getEncoder().encodeToString(pw.getBytes());
                    getToken = encode;
                    stement = 0;
                } else {
                    System.out.println("Pastikan kata sandi anda mengandung karakter unik dengan panjang 8-20");
                    System.out.println("#Exampale123");
                }
            }else {
                System.out.println("password anda tidak sama");
            }
        }while (stement !=0);
        return getToken;
    }
    public static String getUncode(){
        String inputPw = ScannerUtilInfo.input("Masukan Password Anda");
        String decode = Base64.getEncoder().encodeToString(inputPw.getBytes());
        return  decode;
    }
    public static boolean getLoop(){
        boolean isvalid = false;
        do {
            System.out.println("1. lanjut");
            System.out.println("0. Exit");
            String choice = CheckingNotNull.getNotnull("pilih");
            if (choice.equals("1")) {
            isvalid = true;
            } else if(choice.equals("0")){
                isvalid = false;
                break;
            }else{
                System.out.println("not found");
            }
        }while (!isvalid);
        return isvalid;
    }


}
