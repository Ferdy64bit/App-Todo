package ferdy.database.ferdy.MainApp;

import ferdy.database.ferdy.Service.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FerdyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerdyApplication.class, args);
		MainMenu.display();
	}

}
