package com.example.kochamkino;


import com.example.kochamkino.models.Director;
import com.example.kochamkino.models.Grade;
import com.example.kochamkino.models.Movie;
import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.DirectorRepo;
import com.example.kochamkino.repositories.GradeRepo;
import com.example.kochamkino.repositories.MovieRepo;
import com.example.kochamkino.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class DataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepo, MovieRepo movieRepo, DirectorRepo directorRep, GradeRepo gradeRepo) {
        return args ->
        {
            User user = new User("Piotr", "Stachnio", 'm', "piotrstachnio@gmail.com", "cyta", passwordEncoder.encode("haslomaslo"), false);
            Movie movie = new Movie("PitBull","Gowno");
            Director director = new Director("Patryk", "Vega");
            Grade grade = new Grade(10);


            userRepo.save(user);
            movieRepo.save(movie);
            directorRep.save(director);
            gradeRepo.save(grade);

        };
    }
}
