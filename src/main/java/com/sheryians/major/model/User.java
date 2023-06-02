package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;


import java.util.List;

@Entity
@Data
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String firstName;


    private String lastName;

    @Column(nullable = false,unique = true)


    private String email;

    private String password;


    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public User(){

    }
}
