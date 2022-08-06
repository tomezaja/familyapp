package com.familyapp.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class userConfig {
    @Bean
    CommandLineRunner commandLineRunner(userRepository repository) {
        return args -> {

            user miki = new user(
                    "miki", "miki@mail", "slika", "1.2.2222", 5

            );
            user mater = new user(
                    "mater", "mater@mail", "pic", "1.2.2002", null

            );
            repository.saveAll(List.of(miki, mater));

        };
    }

    ;

}
