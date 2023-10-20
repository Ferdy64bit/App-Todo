package ferdy.database.ferdy.Service;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class Register {
    private Integer id;
    private String fristName;
    private String lasrName;
    private String username;
    private String password;
    private String Britday;
    private String number;

    private String email;

    private LocalDate dayLogin;

    public Register(String fristName, String lasrName, String username, String password, String britday, String number, String email, LocalDate dayLogin) {
        this.fristName = fristName;
        this.lasrName = lasrName;
        this.username = username;
        this.password = password;
        Britday = britday;
        this.number = number;
        this.email = email;
        this.dayLogin = dayLogin;
    }

    public static void getRegis(){

    };
}
