package com.example.springproject.domainObject;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    @Column(nullable = false , unique = true)
    private  String username;
    private String name ;
    private  String email;
    private String password;
    private  String surname ;
    private String rol;










//
//

}