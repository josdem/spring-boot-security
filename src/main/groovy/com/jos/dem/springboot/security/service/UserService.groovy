package com.jos.dem.springboot.security.service

import  com.jos.dem.springboot.security.model.User

interface UserService {
  User getUserByUsername(String username)
}
