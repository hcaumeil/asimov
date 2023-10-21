package com.sud.asimov;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
class User (
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public val id: Long? = null,
  public var name: String,
  public var family_name: String,
  public var email: String,
  public var password: String) {
}

// class UserEntry {
//   id: number;
//   name: string;
//   family_name: string;
//   email: string;
//   password: string;
//   role: string;

//   constructor(
//     id: number,
//     name: string,
//     family_name: string,
//     email: string,
//     password: string,
//     basket: string,
//     role: string,
//   ) {
//     this.id = id;
//     this.name = name;
//     this.family_name = family_name;
//     this.email = email;
//     this.password = password;
//     this.role = role;
//   }
// }

