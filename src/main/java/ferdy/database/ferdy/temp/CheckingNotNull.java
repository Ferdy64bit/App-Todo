package ferdy.database.ferdy.temp;

import ferdy.database.ferdy.scanner.ScannerUtilInfo;

public class CheckingNotNull {
    public static String getNotnull(String info){
        boolean isValid = false;
        String fristname;
        do {
            fristname = ScannerUtilInfo.input(info);
            if (fristname.isEmpty()){
                System.out.println("kata tidak boleh kosng");
            }else {
                isValid = true;
            }
        }while (!isValid);
        return fristname;
    }

}
