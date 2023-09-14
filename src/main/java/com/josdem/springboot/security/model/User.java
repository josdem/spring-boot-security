package com.josdem.springboot.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = true)
  private String firstName;

  @Column(nullable = true)
  private String lastName;

  @Column(nullable = true)
  private String email;

  @Column(nullable = false)
  @Enumerated(STRING)
  private Role role;

  @Column(nullable = false)
  private Boolean enabled = false;
}
