package ca.quebec.bootcamp.cloudparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CloudparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudparkingApplication.class, args);
	}

}
