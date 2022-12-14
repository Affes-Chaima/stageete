package com.stage.freeclub.repository;

import java.util.List;
import java.util.Optional;

import com.stage.freeclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

   // Boolean existsByUsername(String username);

   // Boolean existsByEmail(String email);

     User findByEmail(String email);

    User findByEmailAndPassword(String Email, String Password);

}