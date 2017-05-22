package mn.ineg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class SmartwebapplicationApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
				.sources(SmartwebapplicationApplication.class)
				.run(args);
	}
}
