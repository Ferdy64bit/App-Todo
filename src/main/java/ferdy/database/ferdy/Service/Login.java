package ferdy.database.ferdy.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
public class Login {
    private String username;
    private String password;
}
