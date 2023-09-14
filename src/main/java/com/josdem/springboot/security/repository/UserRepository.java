package com.josdem.springboot.security.repository;

import com.josdem.springboot.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findUserByUsername(String username);
}
