package demo.application.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfiguration {

    @Bean("personCommandLineRunner")
    CommandLineRunner personCommandLineRunner(PersonRepository repository) {
        return args -> {
            Person john = new Person(
                    "John Doe",
                    "Reading",
                    "123 Main St",
                    "555-1234"
            );

            Person jane = new Person(
                    "Jane Doe",
                    "Swimming",
                    "456 Elm St",
                    "555-5678"
            );

            repository.saveAll(List.of(john, jane));
        };
    }
}
