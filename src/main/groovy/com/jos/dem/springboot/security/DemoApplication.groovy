package com.jos.dem.springboot.security

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@SpringBootApplication
class DemoApplication {

  @Bean
  PasswordEncoder passwordEncoder() {
    NoOpPasswordEncoder.getInstance()
  }

	static void main(String[] args) {
		SpringApplication.run DemoApplication, args
	}
}
