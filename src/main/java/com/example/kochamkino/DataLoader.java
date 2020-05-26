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
            User user = new User("Piotr", "Stachnio", 'm', "piotrstachnio@gmail.com", "cyta", passwordEncoder.encode("haslomaslo"), "User");

            Director director = new Director("Patryk", "Vega");
            Movie movie = new Movie("PitBull","Gowno", director);
//            Movie movie1 = new Movie("PitBull","Gowno", director);
//            Movie movie2 = new Movie("PitBull","Gowno", director);
//            Movie movie3 = new Movie("PitBull","Gowno", director);

            //Grade grade = new Grade(10, user, movie1);
            User user2 = new User("Tom",   "Tom", 'm', "tom@gmail.com", "tom", passwordEncoder.encode("tom"), "User");



            userRepo.save(user);

            directorRep.save(director);

            movieRepo.save(movie);
//            movieRepo.save(movie1);
//            movieRepo.save(movie2);
//            movieRepo.save(movie3);

            //gradeRepo.save(grade);
            userRepo.save(user2);
        };
    }
}
