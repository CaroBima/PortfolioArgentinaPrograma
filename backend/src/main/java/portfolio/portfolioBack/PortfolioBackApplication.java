package portfolio.portfolioBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;



@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
@SpringBootApplication
//@EnableConfigurationProperties
public class PortfolioBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackApplication.class, args);
	}



}
