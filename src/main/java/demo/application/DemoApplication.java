package demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Main class annotated with @SpringBootApplication to enable auto-configuration, component scanning, and configuration
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
    	// Launch the Spring Boot application
        SpringApplication.run(DemoApplication.class, args);
    }
}
