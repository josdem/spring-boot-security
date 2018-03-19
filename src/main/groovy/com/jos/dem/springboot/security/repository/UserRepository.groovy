package com.jos.dem.springboot.security.repository

import com.jos.dem.springboot.security.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User,Long> {

  User findByUsername(String username)

}
