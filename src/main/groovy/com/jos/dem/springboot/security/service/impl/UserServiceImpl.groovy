package com.jos.dem.springboot.security.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import  com.jos.dem.springboot.security.model.User
import  com.jos.dem.springboot.security.service.UserService
import  com.jos.dem.springboot.security.repository.UserRepository

@Service
class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository

  User getUserByUsername(String username){
    userRepository.findByUsername(username)
  }

}
