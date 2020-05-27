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
            User user = new User("Piotr", "Stachnio", 'm', "piotrstachnio@gmail.com", "cyta", passwordEncoder.encode("haslomaslo"));
            user.setRole("User");
            Director director = new Director("Patryk", "Vega");
            Director director2 = new Director("Tommy", "Bwoii");
            Movie movie = new Movie("PitBull","Artsy", director, 2000);
            Movie movie1 = new Movie("Pill","Gowno", director, 2001);
            Movie movie2 = new Movie("Pit","Thriller", director2, 2002);
            Movie movie3 = new Movie("Bull","Iksde", director2, 2000);


            //Grade grade = new Grade(10, user, movie1);

            Grade grade = new Grade(10, user, movie);
            User user2 = new User("Tom",   "Tom", 'm', "tom@gmail.com", "tom", passwordEncoder.encode("tom"));
            user2.setRole("User");
            Grade grade1 = new Grade(9, user2, movie);
            Grade grade2 = new Grade(2, user2, movie);

            userRepo.save(user);

            directorRep.save(director);
            directorRep.save(director2);
            movieRepo.save(movie);


            //gradeRepo.save(grade);
            movieRepo.save(movie);
            movieRepo.save(movie1);
            movieRepo.save(movie2);
            userRepo.save(user2);
            gradeRepo.save(grade1);
            gradeRepo.save(grade2);
            gradeRepo.save(grade);
        };
    }
}
