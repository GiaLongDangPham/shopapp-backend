package com.project.shopapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);
    // SELECT * FROM users WHERE phoneNumber=?
}
