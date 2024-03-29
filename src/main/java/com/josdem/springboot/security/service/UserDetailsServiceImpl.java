package com.josdem.springboot.security.service;

import com.josdem.springboot.security.model.User;
import com.josdem.springboot.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optional = userRepository.findUserByUsername(username);
    if (optional.isPresent()) {
      User user = optional.get();
      return new org.springframework.security.core.userdetails.User(
          user.getEmail(),
          user.getPassword(),
          Arrays.asList(new SimpleGrantedAuthority(user.getRole().name())));
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
