package com.example.module1.library;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (BookRepository repository) {
        return args -> {
                Book HarryPotter = new Book(
                        "Harry Potter",
                        "Mack",
                        "StinkyGuy",
                        2019
                );

                Book PercyJackson = new Book(
                        "Percy Jackson",
                        "Rick Riordan",
                        "Mr Publisher",
                        2010
                );

                repository.saveAll(
                        List.of(HarryPotter, PercyJackson)
                );


        };
    }
}
