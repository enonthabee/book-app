package com.bookapp.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String role = "USER";
    private String gender;
    private String email;
    private String cellNo;
    private String username;
    private String password;
    /*@OneToMany(mappedBy = "user")
    private Set<Book> borrowedBooks;*/
}
