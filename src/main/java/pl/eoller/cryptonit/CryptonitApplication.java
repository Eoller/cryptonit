package pl.eoller.cryptonit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.eoller.cryptonit.dao.crudrepository.CoinMarCapDao;

@SpringBootApplication
@EnableJpaRepositories
public class CryptonitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptonitApplication.class, args);
	}

}

