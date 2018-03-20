package com.jos.dem.springboot.security.config

import org.springframework.stereotype.Component
import org.springframework.context.ApplicationListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import com.jos.dem.springboot.security.model.User
import com.jos.dem.springboot.security.model.Role

@Component
class Boostrap implements ApplicationListener<ApplicationReadyEvent>{

  @Autowired
  UserRepository userRepository

  @Override
  void onApplicationEvent(final ApplicationReadyEvent event) {
    createUserWithRole('josdem', '12345678', 'joseluis.delacruz@gmail.com', Role.USER)
  }

  private createUserWithRole(String username, String password, String email, Role authority){
    if(!userRepository.findByUsername(username)){
      User user = new User(
        username:username,
        password:new BCryptPasswordEncoder().encode(password),
        email:email,
        role:authority,
        firstname:username,
        lastname:username,
        enabled:true
      )
      userRepository.save(user)
    }
  }

}
