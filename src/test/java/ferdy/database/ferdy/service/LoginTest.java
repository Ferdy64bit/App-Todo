package ferdy.database.ferdy.service;

import ferdy.database.ferdy.Service.Login;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    void loginTest() {
        Login login = new Login("admin","admin");
        System.out.println(login.getUsername());
        System.out.println(login.getPassword());
    }
}
