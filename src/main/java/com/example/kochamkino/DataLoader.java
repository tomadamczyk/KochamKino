package com.example.kochamkino;


import com.example.kochamkino.models.Director;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.DirectorRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Set;

@Configuration
@Slf4j
public class DataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepo, MovieRepo movieRepo, DirectorRepo directorRep) {
        return args ->
        {
            User user = new User("Piotr", "Stachnio", 'm',"mail@gmail.com","cyta", passwordEncoder.encode("haslo"));
            Director director = new Director("Patryk", "Vega");
            Movie movie = new Movie("tytul", "gatunek");
            
            movie.setDirector(director);
            directorRep.save(director);
            userRepo.save(user);
            movieRepo.save(movie);

        };
    }
}
