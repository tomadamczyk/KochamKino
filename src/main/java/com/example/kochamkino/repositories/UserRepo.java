package com.example.kochamkino.repositories;

import com.example.kochamkino.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    UserRepo findByUsername(String username);
}
