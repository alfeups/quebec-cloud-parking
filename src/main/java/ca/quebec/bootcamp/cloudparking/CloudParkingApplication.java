package ca.quebec.bootcamp.cloudparking;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ca.quebec.bootcamp.cloudparking"})
@EnableAutoConfiguration
@Generated
public class CloudParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
