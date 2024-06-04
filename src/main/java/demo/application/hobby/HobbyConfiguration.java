package demo.application.hobby;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HobbyConfiguration {

    @Bean("hobbyCommandLineRunner")
    CommandLineRunner hobbyCommandLineRunner(HobbyRepository repository) {
        return args -> {
            Hobby reading = new Hobby("Reading");
            Hobby swimming = new Hobby("Swimming");

            repository.saveAll(List.of(reading, swimming));
        };
    }
}
