package com.jos.dem.springboot.security.model

import static javax.persistence.EnumType.STRING
import static javax.persistence.GenerationType.AUTO

import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue

@Entity
class User {

  @Id
  @GeneratedValue(strategy=AUTO)
  Long id
  @Column(unique = true, nullable = false)
  String username
  @Column(nullable = false)
  String password
  @Column(nullable = true)
  String firstName
  @Column(nullable = true)
  String lastName
  @Column(nullable = true)
  String email
  @Column(nullable = false)
  @Enumerated(STRING)
  Role role
  @Column(nullable = false)
  Boolean enabled = false
  @Column(nullable = false)
  Date dateCreate = new Date()

}
