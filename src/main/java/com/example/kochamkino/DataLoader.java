package com.example.kochamkino;


import com.example.kochamkino.models.User;
import com.example.kochamkino.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class DataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepo) {
        return args ->
        {
            User user = new User("Piotr", "Stachnio", 'm',"mail@gmail.com","cyta", passwordEncoder.encode("haslo"));
            userRepo.save(user);
            System.out.println(user.toString());
        };
    }
}
