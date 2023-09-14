package com.josdem.springboot.security.config;

import com.josdem.springboot.security.model.Role;
import com.josdem.springboot.security.model.User;
import com.josdem.springboot.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

  private final Environment environment;
  private final UserRepository userRepository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    if (environment.getActiveProfiles().length == 0) {
      log.info("Loading development environment");
      createDefaultUsers();
    }
  }

  private void createDefaultUsers() {
    createUserWithRole("josdem", "12345678", "joseluis.delacruz@gmail.com", Role.USER);
    createUserWithRole("admin", "12345678", "admin@email.com", Role.ADMIN);
  }

  private void createUserWithRole(String username, String password, String email, Role authority) {
    Optional<User> optional = userRepository.findUserByUsername(username);
    if (optional.isEmpty()) {
      User user = new User();
      user.setUsername(username);
      user.setPassword(new BCryptPasswordEncoder().encode(password));
      user.setEmail(email);
      user.setRole(authority);
      user.setFirstName(username);
      user.setLastName(username);
      user.setEnabled(true);
      userRepository.save(user);
    }
  }
}
