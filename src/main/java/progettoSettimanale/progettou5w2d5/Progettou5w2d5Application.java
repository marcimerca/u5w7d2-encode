package progettoSettimanale.progettou5w2d5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import progettoSettimanale.progettou5w2d5.model.Computer;

@SpringBootApplication
public class Progettou5w2d5Application {

	public static void main(String[] args) {
		SpringApplication.run(Progettou5w2d5Application.class, args);
		Computer computer = new Computer();

	}

}
