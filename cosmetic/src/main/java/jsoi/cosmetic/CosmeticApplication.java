package jsoi.cosmetic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CosmeticApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmeticApplication.class, args);
	}

}
